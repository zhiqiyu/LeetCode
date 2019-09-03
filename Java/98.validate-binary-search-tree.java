/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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
    public boolean isValidBST(TreeNode root) {
        // traverse use inorder and check if the lastest one added to the list
        // is always larger than its precedence.

        if (root == null || (root.left == null && root.right == null)) return true;

        List<TreeNode> l = new ArrayList<>();
        traverse(l, root);
        for (int i = 1; i < l.size(); i++) {
            if (l.get(i).val <= l.get(i-1).val) return false;
        }
        return true;
    }

    private void traverse(List<TreeNode> l, TreeNode root) {
        if (root.left != null) {
            traverse(l, root.left);
        }
        l.add(root);
        if (root.right != null) {
            traverse(l, root.right);
        }
    }

    
    // private boolean helper(TreeNode root) {
    //     if (root.left != null && root.right != null) {
    //         return (root.val > root.left.val) && (root.val < root.right.val) && helper(root.left) && helper(root.right);
    //     }
    //     else if (root.left == null && root.right == null) return true;
    //     else if (root.left == null) {
    //         return (root.val < root.right.val) && helper(root.right);
    //     }
    //     else {
    //         return (root.val > root.left.val) && helper(root.left);
    //     }
    // }
}

