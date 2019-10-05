/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int lo = 0;
        int hi = values.size() - 1;

        while (lo < hi) {
            if (!values.get(lo).equals(values.get(hi))) return false; 
            lo++;
            hi--;
        }
        return true;
    }
}
// @lc code=end

