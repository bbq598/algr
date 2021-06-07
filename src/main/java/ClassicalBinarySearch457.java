public class ClassicalBinarySearch457 {

   public int findPosition(int[] nums, int target){

    return findPos(0, nums.length - 1, nums, target);

   }

   private int findPos(int left, int right, int[] nums, int target){
       if(left > right){
           return -1;
       }
       if( left == right){
           if(nums[left] == target){
               return left;
           }
           return -1;
       }
       int mid = (left + right)/2;

       if(nums[mid] == target){
           return mid;
       }else if(nums[mid] < target){
        return findPos(mid + 1, right, nums, target);
       }else {
        return findPos(0, mid, nums, target);
       }
   }


  public static void main(String[] args) {

    int[] arr = {4};
    int target = 3;
    System.out.println(new ClassicalBinarySearch457().findPosition(arr, target));
  }
}
