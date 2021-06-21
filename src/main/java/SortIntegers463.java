import java.util.*;

public class SortIntegers463 {

    public void sortIntegers(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }

        for (int i = 0; i < A.length; i++) {
            sort(A, i);
        }

        List<Integer> size = new ArrayList<>();
        size.add(A.length);
        List<Integer> res = new ArrayList<>();
        int s = size.get(0);
        while (s != 0) {
            res.add(A[0]);
            A[0] = A[s - 1];
            s--;
            sortDown(A, s, 0);
        }

        for (int i = 0; i < res.size(); i++) {
            A[i] = res.get(i);
        }


    }

    public void sortDown(int[] A, int size, int k) {
        int s = size;
        while (k * 2 + 1 < s) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < s && A[son] > A[k * 2 + 2]) {
                son = k * 2 + 2;
            }
            if (A[son] > A[k]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }





    private void sort(int[] A, int k ) {
        while (k  != 0) {
            int parent = (k - 1) / 2;
            if (A[parent] < A[k]) {
                break;
            }
            int temp = A[k];
            A[k] = A[parent];
            A[parent] = temp;
            k = parent;
        }

    }


    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        new SortIntegers463().sortIntegers(A);
        System.out.println(Arrays.toString(A));
        Queue<Integer> q = new PriorityQueue<Integer>();
        q.offer(3);
        q.offer(2);
        q.offer(5);
        q.offer(1);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());

    }

}
