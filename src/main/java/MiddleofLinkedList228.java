public class MiddleofLinkedList228 {
      public static class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode middleNode(ListNode head) {
        // write your code here
        int size = 1;
        if (head == null) {
            return head;
        }
        ListNode res = head;
        while (head.next != null){
            size++;
            head = head.next;
        }

        int mid = size % 2 == 0 ? size / 2 : size / 2 + 1;


        while (mid > 1) {
            res = res.next;
            mid--;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode d = new ListNode(3);
        a.next = b;
        b.next = d;
        MiddleofLinkedList228 m = new MiddleofLinkedList228();
        ListNode c = m.middleNode(a);
        System.out.println(c.val);
    }




}
