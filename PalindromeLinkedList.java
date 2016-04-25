/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // move fast to the end, and slow to the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;

        // reverse the right half
        slow = reverse(slow);

        // run the two pointers head and slow together and compare
        while (slow != null) {
            if (slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = null;
        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            if (t == null) break;
            else {
                p1 = p2;
                p2 = t;
            }
        }
        return p2;
    }
}