/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int non_zero_ind = -1;
        int zero_count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero_count++;
                continue;
            }
            else {
                non_zero_ind++;
                if (non_zero_ind != i) {
                    nums[non_zero_ind] = nums[i];
                }
            }
        }
        for (int i = nums.length - zero_count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

