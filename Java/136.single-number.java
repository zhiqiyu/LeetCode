import java.util.HashSet;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */
class Solution {
    public int singleNumber(int[] nums) {
        // using hashset
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        return (int) set.toArray()[0];
    }
}

