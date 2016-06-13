/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        // Find the middle of the list
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        // Reverse the half after middle 1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode pre = p1;
        ListNode start = pre.next;
        ListNode curr = start.next;
        while (curr != null) {
            start.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = start.next;
        }
        
        // Start reorder one by one 1->2->3->6->5->4 to 1->6->2->5->3->4
        p1 = head;
        p2 = pre.next;
        while (p1 != pre) {
            pre.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = pre.next;
        }
    }
}
