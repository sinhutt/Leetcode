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
    // recursion
    // public TreeNode upsideDownBinaryTree(TreeNode root) {
    //     if (root == null || (root.left == null && root.right == null))
    //         return root;
    //     TreeNode newRoot = upsideDownBinaryTree(root.left);
    //     root.left.left = root.right;
    //     root.left.right = root;
    //     root.left = null;
    //     root.right = null;
    //     return newRoot;
    // }
    
    // iterative
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode prev = null, right = null, next = null;
        while(root != null){
            next = root.left;
            root.left = right;
            right = root.right;
            root.right = prev;
            prev = root;
            root = next;
        }
        return prev;
    }
}