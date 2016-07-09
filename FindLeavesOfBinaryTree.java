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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        helper(root, rs);
        return rs;
    }
    private int helper(TreeNode root, List<List<Integer>> rs) {
        if (root == null) return -1;
        // definition of height for each node in this problem is:
        // its distance to the deepest leaf, where leaf has height 1 and so on.
        int height = 1 + Math.max(helper(root.left, rs), helper(root.right, rs));
        if (rs.size() - 1 < height) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(root.val);
            rs.add(list);
        } else {
            rs.get(height).add(root.val);
        }
        return height;
    }
}