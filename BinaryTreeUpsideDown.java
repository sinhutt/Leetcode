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
    // p.left = parent.right
    // p.right = parent
    
    // recursion
    // O(logn) time
    // O(logn) space
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    
    // iterative
    // O(logn) time
    // O(1) space
    // public TreeNode upsideDownBinaryTree(TreeNode root) {
    //     TreeNode curr = root, parent = null, parentRight = null;
    //     while (curr != null) {
    //         TreeNode parentLeft = curr.left;
    //         curr.left = parentRight;
    //         parentRight = curr.right;
    //         curr.right = parent;
    //         parent = curr;
    //         curr = parentLeft;
    //     }
    //     return parent;
    // }
}