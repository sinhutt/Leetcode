public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }
    
    private int helper(int[] nums, int low, int high) {
        int rob = 0; // max money can get if rob current house
        int notrob = 0; // max money can get if not rob current house
        for (int i = low; i <= high; i++) {
            // if rob ith house, previous house must not be robbed
            int currob = notrob + nums[i]; 
            // if not rob ith house, take the max value of rob (i-1)th house and not rob (i-1)th house
            notrob = Math.max(rob, notrob); 
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}