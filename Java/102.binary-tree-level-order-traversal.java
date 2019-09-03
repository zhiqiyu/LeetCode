/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) return l;

        List<List<TreeNode>> t = new ArrayList<>();
        List<TreeNode> ele = new ArrayList<>();
        ele.add(root);
        t.add(ele);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        l.add(temp);
        helper(t, l);
        return l;
    }

    private void helper(List<List<TreeNode>> l, List<List<Integer>> res) {
        int lvls = l.size();
        int n = l.get(lvls - 1).size();
        List<TreeNode> ele = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeNode t = l.get(lvls - 1).get(i);
            if (t.left != null) {
                ele.add(t.left);
                temp.add(t.left.val);
            }
            if (t.right != null) {
                ele.add(t.right);
                temp.add(t.right.val);
            } 
        }
        if (ele.size() > 0) {
            l.add(ele);
            res.add(temp);
            helper(l, res);
        }
        else return;
    }
}

