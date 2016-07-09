public class Solution {
    public void wiggleSort(int[] nums) {
        /**
         * Use {1,3,6,9,8,2} as input data.
         * Step 1: make each [even, odd] pair to be [small, large] --> {1,3,6,9,2,8}
         * Step 2: make each [odd, even] pair to be [large, small] --> {1,6,3,9,2,8} Done!
         */ 
         for (int i = 1; i < nums.length; i+=2) {
             if (nums[i-1] > nums[i]) swap(i-1, i, nums);
         }
         for (int i = 2; i < nums.length; i+=2) {
             if (nums[i-1] < nums[i]) swap(i-1, i, nums);
         }
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}