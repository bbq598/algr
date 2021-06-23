public class Heapify130 {


    public void heapify(int[] A) {
        // write your code here
        for (int i = (A.length - 1) / 2; i >= 0; i--) {
            sort(A, i);
        }
    }


    private void sort(int[] A, int k) {

        while (k * 2 + 1 < A.length) {
            int son = k * 2 + 1;
            if (k * 2 + 2 < A.length && A[son] > A[k * 2 + 2]) {
                son = k * 2 + 2;
            }

            if (A[k] < A[son]) {
                break;
            }
            int temp = A[son];
            A[son] = A[k];
            A[k] = temp;
            k = son;
        }
    }


    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        new Heapify130().heapify(A);
        System.out.println(A.toString());

    }


}
