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
    // recursive solution, preorder traversal
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return sum * 10 + root.val;
        int res = 0;
        res += helper(root.left, sum * 10 + root.val);
        res += helper(root.right, sum * 10 + root.val);
        return res;
        // more concise:
        // return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
        
    }
}