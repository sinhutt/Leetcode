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
        dfs(root, "", result);
        return result;
    }
    private void dfs(TreeNode root, String path, List<String> result) {
        if (root == null) return;
        if (root.left == null && root.right == null)
            result.add(path + root.val);
        dfs(root.left, path + root.val + "->", result);
        dfs(root.right, path + root.val + "->", result);
    }
}