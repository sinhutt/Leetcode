/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1 - 2 - 3 - 4 - 5 - 6
        // m = 2, n = 5
        // pre = 1, start = 2, curr = 3
        if (head == null) return null;
        ListNode dummy = new ListNode(0); 
        dummy.next = head;
        ListNode pre = dummy; // node before reversing
        for (int i = 1; i <= m-1; i++) pre = pre.next;
        ListNode start = pre.next; // start node of sub-list to be reversed
        ListNode curr = start.next; // curr node to be reversed
        
        for (int i = 0; i < n-m; i++) {
            start.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = start.next;
        }
        // initially:   dummy - 1 - 2 - 3 - 4 - 5 - 6, pre = 1, start = 2, curr = 3
        // 1st reverse: dummy - 1 - 3 - 2 - 4 - 5 - 6, pre = 1, start = 2, curr = 4
        // 2nd reverse: dummy - 1 - 4 - 3 - 2 - 5 - 6, pre = 1, start = 2, curr = 5
        // 3rd reverse: dummy - 1 - 5 - 4 - 3 - 2 - 6, pre = 1, start = 2, curr = 6 (finish)
        return dummy.next;
    }
}