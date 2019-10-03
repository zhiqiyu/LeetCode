/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int cur = 0;
        while (count != k) {
            cur = nums[nums.length - count - 1];
            count++;
        }
        return cur;
    }
}
// @lc code=end

