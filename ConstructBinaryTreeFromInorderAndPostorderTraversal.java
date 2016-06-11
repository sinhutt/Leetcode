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
     * The basic idea is to take the last element in postorder array as the root, 
     * find the position of the root in the inorder array; 
     * then locate the range for left sub-tree and right sub-tree and do recursion. 
     * Use a HashMap to record the index of root in the inorder array.
     */ 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                            HashMap<Integer, Integer> map) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = map.get(postorder[pe]);
        // in inorder array, left subtree is from is to i-1, right subtree is from i+1 to ie
        // in postorder array, left subtree is from ps to ps+i-1-is, right subtree is from ps+i-is to pe-1
        TreeNode left = helper(inorder, is, i-1, postorder, ps, ps+i-1-is, map); 
        TreeNode right = helper(inorder, i+1, ie, postorder, ps+i-is, pe-1, map);
        root.left = left;
        root.right = right;
        return root;
    }
}
