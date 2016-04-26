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
    // recursive
    // public boolean isSymmetric(TreeNode root) {
    //     return (root == null) || (helper(root.left, root.right));
    // }
    
    // private boolean helper(TreeNode left, TreeNode right) {
    //     if (left == null || right == null)
    //         return left == right;
    //     if (left.val != right.val)
    //         return false;
    //     return helper(left.left, right.right) && helper(left.right, right.left);
    // }
    
    // iterative
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root.left != null) {
            if (root.right == null) return false;
            stack.push(root.left);
            stack.push(root.right);
        } else {
            if (root.right != null) return false;
        }
        
        TreeNode left, right;
        while (!stack.empty()) {
            left = stack.pop();
            right = stack.pop();
            if (left.val != right.val) return false;
            
            if (left.left != null) {
                if (right.right == null) return false;
                stack.push(left.left);
                stack.push(right.right);
            } else {
                if (right.right != null) return false;
            }
            
            if (left.right != null) {
                if (right.left == null) return false;
                stack.push(left.right);
                stack.push(right.left);
            } else {
                if (right.left != null) return false;
            }
        }
        return true;
    }
}