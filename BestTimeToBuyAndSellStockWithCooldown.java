public class Solution {
    public int maxProfit(int[] prices) {
        /**
         * Basically for day i there are three types of action we can consider: sell, buy and cooldown.
         * 
         * If we want to buy, then i-1 day must be cooldown, 
         * so after buy today our portfolio value should be cooldown-prices[i]. 
         * if this number is small than buy itself, then we don't buy today.
         *
         * If we want to cooldown, then i-1 day must be cooldown or sell. 
         * So we take the max of these two.
         *
         * If we want to sell, then before day i, we must have position, 
         * so after sell our portfolio value should be day i-1's buy+prices[i]. 
         * if this value is smaller than sell itself, then we don't sell today.
         */
        if (prices.length < 2) return 0;
        // on the 1st day, we can only buy
        int buy = -prices[0], sell = 0, cooldown = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = buy;
            buy = Math.max(buy, cooldown - prices[i]);
            cooldown = Math.max(sell, cooldown);
            sell = Math.max(sell, temp + prices[i]);          
        }
        // on the last day we can only sell or cooldown
        return sell>cooldown?sell:cooldown;
    }
}