/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    // stack solution
    public ListNode reverseList_stack(ListNode head) {
        if (head == null) return head;
        
        Stack<ListNode> stack = new Stack<>();
        ListNode newhead = null;

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        newhead = stack.pop();
        ListNode last = newhead;
        while (!stack.isEmpty()) {
            last.next = stack.pop();
            last = last.next;
        }
        last.next = null;
        return newhead;
    }

    // iteration solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode next = head.next;
        head.next = null;
        ListNode last = head;
        head = next;
        next = head.next;
        while (head != null) {
            next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
        return last;
    }
}

