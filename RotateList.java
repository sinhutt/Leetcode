/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy, mid = dummy;
        int len = 0;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        for (int i = 0; i < len - k % len; i++) {
            mid = mid.next;
        }
        last.next = dummy.next;
        dummy.next = mid.next;
        mid.next = null;
        return dummy.next;
    }
}