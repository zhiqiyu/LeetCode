/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) return 0;

        int curSum = 0;
        int largest = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > curSum + nums[i]) {
                curSum = nums[i];
            }
            else {
                curSum += nums[i];
            }
            largest = Math.max(largest, curSum);
        }

        return largest;
    }
}

