public class Solution {
    // recursive solution
    // public int findPeakElement(int[] nums) {
    //     return helper(nums, 0, nums.length - 1);
    // }
    // private int helper(int[] nums, int left, int right) {
    //     if (left == right) return left;
    //     int mid = (left + right) / 2;
    //     if (nums[mid] > nums[mid+1]) 
    //         return helper(nums, left, mid);
    //     else
    //         return helper(nums, mid+1, right);
    // }
    
    // iterative solution
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid+1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}