public class Solution {
    public void rotate(int[] nums, int k) {
        // method 1:
        // if (nums.length <= 1) return;
        
        // int step = k % nums.length;
        // int[] tmp = new int[step];
        // for (int i = 0; i < step; i++) {
        //     tmp[i] = nums[nums.length - step + i];
        // }
        // for (int i = nums.length - step - 1; i >= 0; i--) {
        //     nums[i + step] = nums[i];
        // }
        // for (int i = 0; i < step; i++) {
        //     nums[i] = tmp[i];
        // }
        
        // method 2:
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}