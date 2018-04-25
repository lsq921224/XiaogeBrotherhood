public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int n = prices.length;
        // max money in hand after each action
        int[] sell = new int[n];
        int[] donothing = new int[n];
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < n; i++){
            donothing[i] = Math.max(donothing[i - 1], sell[i - 1]);
            sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], donothing[i - 2]);
        }
        return Math.max(sell[n - 1], donothing[n - 1]);
    }
}
