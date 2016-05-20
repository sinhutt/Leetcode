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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rs = new ArrayList<Integer>();
        helper(root, rs, 0);
        return rs;
    }
    private void helper(TreeNode root, List<Integer> rs, int depth) {
        if (root == null) return;
        if (depth == rs.size()) rs.add(root.val);
        helper(root.right, rs, depth + 1);
        helper(root.left, rs, depth + 1);
    }
}