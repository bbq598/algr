public class FindPeakElement75 {
    public int findPeak(int[] A) {
        // write your code here
        int left = 0;
        int right = A.length - 1;

        while (left + 1 < right) {
            int mid = right + (left - right) / 2;


            if (A[mid] < A[mid + 1]) {
                 left = mid;
            } else if (A[mid] > A[mid + 1]) {
                right = mid;
            }else {
                return mid;
            }
        }

        return A[left] > A[right] ? left : right;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 5, 7, 6};
        System.out.println(new FindPeakElement75().findPeak(A));
    }
}
