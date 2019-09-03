/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        else if (r1 != null && r2 != null) return (r1.val == r2.val) && helper(r1.left, r2.right) && helper(r1.right, r2.left);
        else return false;
    }
}

