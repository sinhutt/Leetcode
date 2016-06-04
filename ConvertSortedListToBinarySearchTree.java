/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, null); // note: tail is initially null
    }
    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) return null; // must return null here, cannot return head or tail
        ListNode slow = head, fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode mid = new TreeNode(slow.val);
        mid.left = helper(head, slow);
        mid.right = helper(slow.next, tail);
        return mid;
    }
}