public class PartitionArray31 {

    public int partitionArray(int[] nums, int k) {
        // write your code here
        int left = -1;
        int right = nums.length;
        int index = 0;
        while (index < right){
            int n = nums[index];
            if(n < k){
                left++;
                swap(nums,index,left);
            }else if(n > k){
                right--;
                swap(nums, index, right);
                index--;
            }
            index++;
        }
        return left + 1;
    }

    private static void swap(int [] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 1};
        int k = 2;
        System.out.println(new PartitionArray31().partitionArray(nums,k));

    }

}
