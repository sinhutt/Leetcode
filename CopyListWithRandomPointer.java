/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * An intuitive solution is to keep a hash table for each node in the list, 
     * via which we just need to iterate the list in 2 rounds respectively to create nodes and assign the values for their random pointers. 
     * As a result, the space complexity of this solution is O(N), although with a linear time complexity.
     * As an optimised solution, we could reduce the space complexity into constant. 
     * The idea is to associate the original node with its copy node in a single linked list. 
     * In this way, we don't need extra space to keep track of the new nodes.
     * 
     * The idea is:
     * Step 1: create a new node for each existing node and join them together
     * eg: A->B->C will be A->A'->B->B'->C->C'
     * 
     * Step2: copy the random links: for each new node n', n'.random = n.random.next
     * 
     * Step3: detach the list: basically n.next = n.next.next; n'.next = n'.next.next
     */ 
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode n = head;
        while (n != null) {
            RandomListNode tmp = n.next;
            RandomListNode n2 = new RandomListNode(n.label);
            n.next = n2;
            n2.next = tmp;
            n = tmp;
        }
        n = head;
        while (n != null) {
            RandomListNode n2 = n.next;
            if (n.random != null) 
                n2.random = n.random.next;
            n = n.next.next;
        }
        n = head;
        RandomListNode head2 = head.next;
        RandomListNode n2 = head.next;
        while (n != null && n2 != null) {
            n.next = n.next.next;
            if (n2.next == null) break;
            n2.next = n2.next.next;
            n = n.next;
            n2 = n2.next;
        }
        return head2;
    }
}