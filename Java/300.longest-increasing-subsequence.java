/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        
        int res = 1;

        // f(x_t) = max(f(x_{t+i}) for x_{t+i} > x_t)
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }
            dp[i] = temp;
            if (dp[i] > res) res = dp[i];
        }
        return res;
    }
}
// @lc code=end

