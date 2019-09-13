/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int min;
        int max;

        int result = min = max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], nums[i]*max);
                min = Math.min(nums[i], nums[i]*min);
            }
            else {
                int temp = max;
                max = Math.max(nums[i], nums[i]*min);
                min = Math.min(nums[i], nums[i]*temp);
            }
            if (result < max) result = max;
        }
        return result;
    }
}

