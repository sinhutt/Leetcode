public class Solution {
    // // recursive, DP
    // public int coinChange(int[] coins, int amount) {
    //     if (amount < 1) return 0;
    //     return helper(coins, amount, new int[amount]);
    // }
    
    // // count[i-1] stores the min number of coins to get rem = i
    // private int helper(int[] coins, int rem, int[] count) { 
    //     // base cases
    //     if (rem < 0) return -1; // not valid
    //     if (rem == 0) return 0; // done
    //     if (count[rem-1] != 0) return count[rem-1]; // already computed
    //     int min = Integer.MAX_VALUE;
    //     for (int coin : coins) {
    //         int res = helper(coins, rem-coin, count);
    //         if (res >= 0 && res < min)
    //             min = res + 1;
    //     }
    //     count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
    //     return count[rem-1];
    // }

    
    // iterative, DP
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 1;
        while (sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum-coin] != -1) {
                    int temp = dp[sum-coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
            sum++;
        }
        return dp[amount]; 
    }
}