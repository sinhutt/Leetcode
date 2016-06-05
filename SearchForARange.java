public class Solution {
    // binary search, 1-pass
    // public int[] searchRange(int[] nums, int target) {
    //     int[] res = {-1, -1};
    //     int lo = 0, hi = nums.length - 1;
    //     while (nums[lo] < nums[hi]) {
    //         int mid = (lo + hi) / 2;
    //         if (nums[mid] > target) {
    //             hi = mid - 1;
    //         } else if (nums[mid] < target) {
    //             lo = mid + 1;
    //         } else {
    //             if (nums[lo] == nums[mid]) hi--;
    //             else lo++;
    //         }
    //     }
    //     if (nums[lo] == nums[hi] && nums[lo] == target) {
    //         res[0] = lo;
    //         res[1] = hi;
    //     }
    //     return res;
    // }
    
    // binary search, 2-pass
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        result[0] = (lo < nums.length && nums[lo] == target) ? lo : -1;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        result[1] = (hi >= 0 && nums[hi] == target) ? hi : -1;
        return result;
    }
}