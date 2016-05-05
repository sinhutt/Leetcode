public class Solution {
    public int maxProfit(int[] prices) {
        // Solution 1:
        // int profit = 0, i = 0;
        // while (i < prices.length) {
        //     // find next local minimum
        //     while (i < prices.length-1 && prices[i+1] <= prices[i]) i++;
        //     int min = prices[i]; 
        //     i++; // need increment to avoid infinite loop for "[1]"
        //     // find next local maximum
        //     while (i < prices.length-1 && prices[i+1] >= prices[i]) i++;
        //     // calculate profit
        //     profit += i < prices.length ? prices[i] - min : 0;
        //     i++; 
        // }
        // return profit;
        
        // Solution 2:
        // the code has no conflict with the requirement "you can't sell and buy at the same time position". 
        // Accumulating the gain profit every day does not have to mean that I sell and buy the stock every day. 
        // I just check my account and say :"wow, I gained more xx profit!" when the stock price is increasing.
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i]) profit += prices[i+1] - prices[i];
        }
        return profit;
    }
}