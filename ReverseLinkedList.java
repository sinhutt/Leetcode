/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        /*
         * Iterative Solution
         */
        // if (head == null || head.next == null) return head;
        // ListNode p1 = head;
        // ListNode p2 = head.next;
        // head.next = null;
        // while (p1 != null && p2 != null) {
        //     ListNode t = p2.next;
        //     p2.next = p1;
        //     if (t == null) break;
        //     else {
        //         p1 = p2;
        //         p2 = t;
        //     }
        // }
        // return p2;
        
        /*
         * Recursive Solution
         */
        if (head == null || head.next == null) return head;
        ListNode second = head.next;
        head.next = null;
        ListNode rest = reverseList(second); // rest is the end of the linkedlist, that's why we return it at the end
        second.next = head;
        return rest;
    }
}