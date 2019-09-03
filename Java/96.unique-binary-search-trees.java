/*
 * @lc app=leetcode id=96 lang=java
 *
 * [96] Unique Binary Search Trees
 */
class Solution {
    public int numTrees(int n) {
        // dynamic programming

        if (n < 2) return 1;

        int[] f = new int[n + 1];  // unique BST for n node
        f[0] = 1;
        f[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }
}

