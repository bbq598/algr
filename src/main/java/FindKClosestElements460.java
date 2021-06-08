import java.util.Arrays;
import java.util.Map;

public class FindKClosestElements460 {


    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here

        int left = 0;
        int right = A.length - 1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;
            int n = A[mid];

            if (n < target) {
                left = mid;
            }else {
                right = mid;
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (index < k ){


            if(left < 0){
                result[index] = A[right];
                right++;
            }else if (right >= A.length ){
                result[index] = A[left];
                left--;
            }else if(  Math.abs(A[left] - target) <= Math.abs(A[right] - target)){
                result[index] = A[left];
                left--;
            }else {
                result[index] = A[right];
                right++;
            }
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,4,6,10,20};
        int targe = 21;
        int k = 4;
        FindKClosestElements460 f = new FindKClosestElements460();
        System.out.println(Arrays.toString(f.kClosestNumbers(A, targe, k)));
    }

}
