public class Solution {
    // when there are duplicates, worst case is O(n)
    // e.g. 1 1 1 1 1 1 5
    
    // iterative
    // public boolean search(int[] nums, int target) {
    //     if (nums == null || nums.length == 0) return false;
    //     int l = 0, r = nums.length - 1;
    //     while (l <= r) {
    //         int mid = (l + r) / 2;
    //         if (nums[mid] == target) 
    //             return true;
    //         // right half is sorted
    //         if (nums[mid] < nums[r]) {
    //             if (nums[mid] < target && target <= nums[r])
    //                 l = mid + 1;
    //             else
    //                 r = mid - 1;
    //         // left half is sorted
    //         } else if (nums[mid] > nums[r]) {
    //             if (nums[l] <= target && target < nums[mid])
    //                 r = mid - 1;
    //             else
    //                 l = mid + 1;
    //         } else {
    //             r--;
    //         }
    //     }
    //     return false;
    // }
    
    // recursive
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    private boolean helper(int[] nums, int target, int l, int r) {
        if (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) 
                return true;
            // right half is sorted
            if (nums[mid] < nums[r]) {
                if (nums[mid] < target && target <= nums[r])
                    return helper(nums, target, mid+1, r);
                else
                    return helper(nums, target, l, mid-1);
            } else if (nums[mid] > nums[r]) {
                if (nums[l] <= target && target < nums[mid])
                    return helper(nums, target, l, mid-1);
                else
                    return helper(nums, target, mid+1, r);
            } else
                return helper(nums, target, l, r-1);
        }
        return false;
    }
}