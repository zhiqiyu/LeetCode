/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max_profit = 0;
        int slo = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= prices[slo]) slo = i;
            else {
                max_profit = Math.max(max_profit, prices[i] - prices[slo]);
            }
        }
        return max_profit;
    }
}

