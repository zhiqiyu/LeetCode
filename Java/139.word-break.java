import java.util.List;

/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()]; 
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if ((j == 0 || dp[j-1]) && wordDict.contains(sub)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
}

