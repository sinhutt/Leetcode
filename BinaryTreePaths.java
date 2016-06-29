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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) return result;
        dfs(root, "", result);
        return result;
    }
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }
        if (root.left != null)
            dfs(root.left, path + root.val + "->", result);
        if (root.right != null)
            dfs(root.right, path + root.val + "->", result);
    }
}