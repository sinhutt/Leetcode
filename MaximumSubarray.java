public class Solution {
    // O(n) solution
    /**
     * Algorithm starts at the left end (element A[1]) and scans through to the right end (element A[n]), 
     * keeping track of the maximum sum subvector seen so far. The maximum is initially A[0]. 
     * Suppose we've solved the problem for A[1 .. i - 1]; how can we extend that to A[1 .. i]? 
     * The maximum sum in the first I elements is either the maximum sum in the first i - 1 elements (which we'll call MaxSoFar), or it is that of a subvector that ends in position i (which we'll call MaxEndingHere).
     * MaxEndingHere is either A[i] plus the previous MaxEndingHere, or just A[i], whichever is larger.
     */ 
    // public int maxSubArray(int[] nums) {
    //     int maxSoFar = nums[0], maxEndingHere = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
    //         maxSoFar = Math.max(maxEndingHere, maxSoFar);
    //     }
    //     return maxSoFar;
    // }
    
    // divide and conquer solution
    /**
     * Step1. Select the middle element of the array. So the maximum subarray may contain that middle element or not.
     * Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.
     * note: either the left or right subarray case must contain the middle element.
     * Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray
     * Step 3 return the maximum of those three answer.
     */ 
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int start, int end) {
        if (start == end) return nums[start];
        int mid = (start + end)/2;
        int leftMax = helper(nums, start, mid);
        int rightMax = helper(nums, mid + 1, end);
        int leftMaxIncMid = nums[mid];
        int rightMaxIncMid = nums[mid + 1];
        int temp = 0;
        for (int i = mid; i >= start; i--) {
            temp += nums[i];
            leftMaxIncMid = Math.max(leftMaxIncMid, temp);
        }
        temp = 0;
        for (int i = mid+1; i <= end; i++) {
            temp += nums[i];
            rightMaxIncMid = Math.max(rightMaxIncMid, temp);
        }
        return Math.max(Math.max(leftMax, rightMax), leftMaxIncMid + rightMaxIncMid);
    }
}