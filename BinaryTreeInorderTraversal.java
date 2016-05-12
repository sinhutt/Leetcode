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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> in = new LinkedList<Integer>();
//         helper(root, in);
//         return in;
//     }
    
//     private void helper(TreeNode root, List<Integer> in) {
//         if (root == null) return;
//         helper(root.left, in);
//         in.add(root.val);
//         helper(root.right, in);
//     }
// }

// Iterative
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            in.add(cur.val);
            cur = cur.right;
        }
        return in;
    }
}