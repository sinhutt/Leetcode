/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // iterative
        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        // ListNode curr = head, prev = dummy;
        // while (curr != null) {
        //     if (curr.val == val) {
        //         prev.next = curr.next;
        //     } else {
        //         prev = curr;
        //     }
        //     curr = curr.next;
        // }
        // return dummy.next;
        
        // recursive
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val? head.next : head;
    }
}