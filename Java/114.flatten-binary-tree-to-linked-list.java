/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
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
    public void flatten(TreeNode root) {
        if (root != null) {
            TreeNode temp =helper(root);
        }
    }

    private TreeNode helper(TreeNode root) {
        TreeNode temp = root.right;
        TreeNode left_last = root;
        TreeNode right_last = root;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;            // important to clear left branch
            left_last = helper(root.right);
        }
        if (temp != null) {
            left_last.right = temp;
            right_last = helper(temp);
            return right_last;
        }
        else return left_last;
    }
}

