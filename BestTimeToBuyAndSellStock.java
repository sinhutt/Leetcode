public class Solution {
    public int maxProfit(int[] prices) {
        // int min = Integer.MAX_VALUE, max = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     min = Math.min(min, prices[i]);
        //     max = Math.max(max, prices[i]-min);
        // }
        // return max;
        
        // Kadane's algorithm
        // if the interviewer twists the question slightly by giving the difference array of prices
        // find a contiguous subarray giving maximum profit
        // i.e. find the max sum of contiguous subarray
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
}