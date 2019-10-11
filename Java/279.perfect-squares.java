/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int j = 1;
            int temp = 99;
            while (i - j * j >= 0) {
                // dp[i] = min(dp[i-1x1]+1, dp[i-2x2]+1, dp[i-3x3]+1, ... for i-mxm >= 0)
                temp = Math.min(temp, 1 + dp[i - j * j]);
                j++;
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
// @lc code=end

