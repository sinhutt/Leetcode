public class Solution {
    // iterative
    // public int searchInsert(int[] nums, int target) {
    //     int low = 0, high = nums.length - 1;
    //     while (low <= high) {
    //         int mid = (low + high) / 2;
    //         if (nums[mid] == target) return mid;
    //         else if (nums[mid] < target) low = mid + 1;
    //         else high = mid - 1;
    //     }
    //     return low;
    // }
    
    // recursive
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        return helper(nums, low, high, target);    
    }
    private int helper(int[] nums, int low, int high, int target) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) return helper(nums, mid + 1, high, target);
            else return helper(nums, low, mid - 1, target);
        }
        return low;
    }
    
}