import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
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

    private TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        helper(root, p, q);
        return res;
    }

    private int helper(TreeNode root, TreeNode p, TreeNode q) {
        // Given a tree node, return how many target nodes are in this tree
        if (res != null) return 0;
        if (root == null) return 0;
        int count = 0;
        boolean root_is = false;
        if (root.equals(p) || root.equals(q)) {
            count++;
            root_is = true;
        }

        int cleft = helper(root.left, p, q);
        int cright = helper(root.right, p, q);

        count += (cleft + cright);

        if (count == 2) {
            if (root_is) res = root;
            else if (cleft == 2) helper(root.left, p, q);
            else if (cright == 2) helper(root.right, p, q);
            else res = root;
        }
        return count;
    }
}
// @lc code=end

