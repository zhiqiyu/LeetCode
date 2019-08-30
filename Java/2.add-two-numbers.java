/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode(0);  // peudo head
        ListNode cur = sum;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1val = l1 == null? 0: l1.val;
            int l2val = l2 == null? 0: l2.val;
            
            int cur_sum = l1val + l2val + carry;
            if (cur_sum >= 10) carry = 1;
            else carry = 0;
            ListNode cur_node = new ListNode(cur_sum % 10);
            cur.next = cur_node;
            cur = cur.next;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
        }

        if (carry == 1) cur.next = new ListNode(1);
        return sum.next;
    }
}

