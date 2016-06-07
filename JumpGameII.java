public class Solution {
    public int jump(int[] nums) {
        // Method 1: this works, but exceeds the time limit
        // int[] dp = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (j + nums[j] >= i) {
        //             dp[i] = dp[j] + 1;
        //             break;
        //         }
        //     }
        // }
        // return dp[nums.length-1];
        
        // Method 2: 
        /**
         * The main idea is based on greedy. 
         * Let's say the range of the current jump is [curBegin, curEnd], 
         * curFarthest is the farthest point that all points in [curBegin, curEnd] can reach. 
         * Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest, etc
         */ 
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
                if (curEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}