public class Solution {
    // O(n) solution
    // public int minSubArrayLen(int s, int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
    //     int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
    //     while (j < nums.length) {
    //         sum += nums[j];
    //         j++;
    //         while (sum >= s) {
    //             min = Math.min(min, j - i);
    //             sum -= nums[i];
    //             i++;
    //         }
    //     }
    //     return min == Integer.MAX_VALUE ? 0 : min;
    // }
    
    // O(nlogn solution)
    /**
     * first compute all the partial sums,
     * where partial[i] is the sum of the first i integers, i>= 0, so i goes from 1 to n
     * next, for each i, we find the min length of a subarray from i+1 (inclusive) for which sum >= s using binary search
     */ 
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] partialSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++)
            partialSum[i+1] = partialSum[i] + nums[i];
        if (partialSum[nums.length] < s) return 0;
        int minLen = nums.length;
        for (int i = 0; i < partialSum.length; i++) {
            int len = binarySearch(nums, i, partialSum, s);
            minLen = Math.min(minLen, len);
        }
        return minLen;
    }
    private int binarySearch(int[] nums, int start, int[] partialSum, int s) {
        int l = start, r = partialSum.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (partialSum[mid] - partialSum[start] < s)
                l = mid + 1;
            else {
                if (mid > 0 && partialSum[mid-1] - partialSum[start] < s)
                    return mid - start;
                else
                    r = mid - 1;
            }
        }
        return partialSum.length;
    }
    
}