public class Solution {
    public int rob(int[] nums) {
        int rob = 0; // max money can get if rob current house
        int notrob = 0; // max money can get if not rob current house
        for (int i = 0; i < nums.length; i++) {
            // if rob ith house, previous house must not be robbed
            int currob = notrob + nums[i]; 
            // if not rob ith house, take the max value of rob (i-1)th house and not rob (i-1)th house
            notrob = Math.max(rob, notrob); 
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
}