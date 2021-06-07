import java.util.Arrays;

public class SortColors148 {

  public void sortColors(int[] nums) {
      int n = sort( nums, 0, 0);
      sort(nums, n, 1);
  }

  private int sort(int[] nums, int start, int target){
    int zero = start;

    for (int i = start; i < nums.length; i++){
        if(nums[i] == target){
            swap(nums, zero, i );
            zero++;
        }

    }
      return zero;
  }



  private void swap(int[]nums, int a, int b){
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 1, 2};
    new SortColors148().sortColors(arr);
    System.out.println(Arrays.toString(arr));
  }
}
