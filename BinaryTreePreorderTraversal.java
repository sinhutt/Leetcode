/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive
// public class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> pre = new LinkedList<Integer>();
//         helper(root, pre);
//         return pre;
//     }
//     private void helper(TreeNode root, List<Integer> pre) {
//         if (root == null) return;
//         pre.add(root.val);
//         helper(root.left, pre);
//         helper(root.right, pre);
//     }
// }

// Iterative
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre = new LinkedList<Integer>();
        if (root == null) return pre;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        // note: 
        // 1. use stack, not queue,
        // so that we obey preorder traversal 
        // 2. always push right node onto the stack first, 
        // so that when we pop, we pop the left node first
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            pre.add(cur.val);
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return pre;
    }
}
