public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[r]) { // right half is sorted
                if (nums[mid] < target && target <= nums[r])
                    l = mid + 1;
                else 
                    r = mid - 1;
            } else if (nums[mid] > nums[r]) { // left half is sorted
                if (nums[l] <= target && target < nums[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            } else { // handles duplicates
                r--;
            }
        }
        return -1;
    }
}