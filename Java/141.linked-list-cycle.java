/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
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
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slo = head;
        ListNode fast = head.next;
        while (slo != fast) {
            if (slo == null || fast == null || fast.next == null) return false;
            slo = slo.next;
            fast = fast.next.next;
        }
        return true;
    }
}

