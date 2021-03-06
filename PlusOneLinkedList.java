/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Recursive Solution
    public ListNode plusOne(ListNode head) {
        int carry = helper(head);
        if (carry == 0) return head;
        else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }
    
    private int helper(ListNode head) {
        if (head == null) return 1;
        int carry = helper(head.next);
        if (carry == 0) return 0;
        int val = head.val + 1;
        head.val = val % 10;
        return val / 10;
    }
}