/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* Solution:
         *   Use HashMap data structure to store {remain, index} pair.
         */

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return new int[] {map.get(nums[i]), i};
            else map.put(target - nums[i], i);
        }

        return null;
    }
}

