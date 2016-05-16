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
    // public int rob(TreeNode root) {
    //     if (root == null) return 0;
    //     int val = root.val;
    //     if (root.left != null)
    //         val += rob(root.left.left) + rob(root.left.right);
    //     if (root.right != null)
    //         val += rob(root.right.left) + rob(root.right.right);
    //     return Math.max(val, rob(root.left) + rob(root.right));
    // }
    
    // DP
    // public int rob(TreeNode root) {
    //     Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    //     return helper(root, map);
    // }
    // private int helper(TreeNode root, Map<TreeNode, Integer> map) {
    //     if (root == null) return 0;
    //     if (map.containsKey(root)) return map.get(root);
    //     int val = root.val;
    //     if (root.left != null)
    //         val += helper(root.left.left, map) + helper(root.left.right, map);
    //     if (root.right != null)
    //         val += helper(root.right.left, map) + helper(root.right.right, map);
    //     val = Math.max(val, helper(root.left, map) + helper(root.right, map));
    //     map.put(root, val);
    //     return val;
    // }
    
    // tricky
    public int rob(TreeNode root) {
        /**
         * for each tree root, there are two scenarios: it is robbed or is not.
         * Redefine rob(root) as a new function which will return an array of two elements, 
         * the first element of which denotes the maximum amount of money that can be robbed if "root" is not robbed, 
         * while the second element signifies the maximum amount of money robbed if root is robbed.
         */
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    private int[] helper(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}