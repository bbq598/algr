public class FindMinimuminRotatedSortedArray159 {

    public int findMin(int[] nums) {
        // write your code here

        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right){

            int mid = right + (left - right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid;
            }else{
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }

    public static void main(String[] args) {

        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(new FindMinimuminRotatedSortedArray159().findMin(nums));


    }


}
