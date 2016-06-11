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
    /**
     * The basic idea is to take the first element in preorder array as the root, 
     * find the position of the root in the inorder array; 
     * then locate the range for left sub-tree and right sub-tree and do recursion. 
     */ 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int ps, int[] inorder, int is, int ie) {
        if (ps > preorder.length - 1 || is > ie) 
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        // find the index of current root in inorder
        int i = 0;
        for (int j = is; j <= ie; j++) {
            if (inorder[j] == root.val) i = j;
        }
        // in preorder array, left subtree starts from ps + 1, right subtree starts from ps + 1 - (i - 1 - is + 1)
        root.left = helper(preorder, ps + 1, inorder, is, i - 1);
        root.right = helper(preorder, ps + 1 + i - is, inorder, i + 1, ie);
        return root;
    }
}

