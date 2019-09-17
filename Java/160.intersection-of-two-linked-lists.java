/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    private Set<ListNode> set = new HashSet<>();
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (true) {
            if (curA == null || curB == null) break;
            curA = curA.next;
            curB = curB.next;
        }

        ListNode shorter = curA == null? headA: headB;
        ListNode longer = shorter == headA? headB: headA;

        while (shorter != null) {
            set.add(shorter);
            if (set.contains(longer)) return longer;
            shorter = shorter.next;
            longer = longer.next;
        }
        while (longer != null) {
            if (set.contains(longer)) return longer;
            longer = longer.next;
        }
        return null;
    }
}

