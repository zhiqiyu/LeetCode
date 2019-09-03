/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     // Solution 1: Recursion
    //     if (root == null) return new ArrayList<Integer>();
    //     List<Integer> ans = new ArrayList<>();
    //     traverse(ans, root);
    //     return ans;
    // }

    // private void traverse(List<Integer> res, TreeNode root) {
    //     if (root.left != null) traverse(res, root.left);
    //     res.add(root.val);
    //     if (root.right != null) traverse(res, root.right);
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        // Solution 2: Iteration
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeNode cur = root;
        Stack<TreeNode> s = new Stack<>();
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            ans.add(cur.val);
            cur = cur.right;
        }
        return ans;
    }
}

