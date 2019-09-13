/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slo = head;
        ListNode fast = head.next;
        while (slo != fast) {
            if (slo == null || fast == null || fast.next == null) return null;
            slo = slo.next;
            fast = fast.next.next;
        }
        return slo;
    }
}

