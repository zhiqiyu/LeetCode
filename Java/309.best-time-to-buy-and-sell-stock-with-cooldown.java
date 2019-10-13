/*
 * @lc app=leetcode id=309 lang=java
 *
 * [309] Best Time to Buy and Sell Stock with Cooldown
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int[] dp = new int[prices.length];
        int[] max_track = new int[prices.length];
        dp[prices.length - 1] = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            helper(prices, i, dp, max_track);
        }

        return max_track[0];
    }

    private void helper(int[] prices, int cur, int[] dp, int[] pre_max) {
        if (cur >= prices.length) return;
        dp[cur] = 0;
        for (int i = 1; i + cur < dp.length; i++) {
            if (prices[cur + i] < prices[cur]) continue;
            else {
                int next_max = 0;
                if (cur + i + 2 < prices.length) next_max = pre_max[cur + i + 2];
                dp[cur] = Math.max(dp[cur], prices[cur + i] - prices[cur] + next_max);
            }
        }
        pre_max[cur] = dp[cur] > pre_max[cur + 1] ? dp[cur] : pre_max[cur + 1];
    }
}
// @lc code=end

