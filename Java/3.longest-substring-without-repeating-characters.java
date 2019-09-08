import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int longest = 0;
        for (int i = 0; i <s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }
            else {
                i = map.get(s.charAt(i)) + 1;
                map.clear();
                map.put(s.charAt(i), i);
            }
            longest = Math.max(map.size(), longest);
        }
        return longest;
    }
}

