/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // iterative
        // ListNode headNode = new ListNode(-1);
        // ListNode curNode = headNode;
        // while (l1 != null && l2 != null) {
        //     if (l1.val <= l2.val) {
        //         curNode.next = l1;
        //         l1 = l1.next;
        //     } else {
        //         curNode.next = l2;
        //         l2 = l2.next;
        //     }
        //     curNode = curNode.next;
        // }
        // if (l1 == null) curNode.next = l2;
        // if (l2 == null) curNode.next = l1;
        // return headNode.next;
        
        // recursive
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode mergeHead;
        if (l1.val <= l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}