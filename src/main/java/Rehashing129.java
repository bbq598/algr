import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Rehashing129 {



    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here

        ListNode[] newTable = new ListNode[hashTable.length * 2];

        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                ListNode node = hashTable[i];
                List<ListNode> nodeList = new ArrayList<>();
                nodeList.add(node);
                while (node.next != null) {
                    node = node.next;
                    nodeList.add(node);
                }

                for (int j = nodeList.size() - 1; j >= 0 ; j--) {
                    ListNode node1 = nodeList.get(j);
                    int hashCode = hashcode(node1.val, newTable.length);
                    node1.next = newTable[hashCode];
                    newTable[hashCode] = node1;
                }

            }
        }

        return newTable;
    }


    int hashcode(int key, int capacity) {
        if (key >= 0) {
            return key % capacity;
        }else{
            return (key % capacity + capacity) % capacity;
        }


    }

    public static void main(String[] args) {

        ListNode node = new ListNode(42);
        node.next = new ListNode(32);
        ListNode node1 = new ListNode(-7);
        ListNode[] list = new ListNode[5];
        list[2] = node;
        list[3] = node1;
        Rehashing129 r = new Rehashing129();
        r.rehashing(list);

    }


}
