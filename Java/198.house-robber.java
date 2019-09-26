/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */
class Solution {

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]); 

        int[] trace = new int[nums.length];
        trace[0] = nums[0];
        trace[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            trace[i] = Math.max(trace[i-2] + nums[i], trace[i-1]);
        }

        return Math.max(trace[nums.length - 1], trace[nums.length - 2]);
    }
}

