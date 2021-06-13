import java.util.LinkedList;
import java.util.List;

public class ImplementQueuebyLinkedList492 {

    private LinkedList<Integer> data = new LinkedList<>();

    public void enqueue(int item) {
        // write your code here
        data.add(item);
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        return data.removeFirst();
    }


    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        n %= m;
        System.out.println( n );
    }

}
