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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        helper(root, sum, result, new LinkedList<Integer>());
        return result;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>> result, List<Integer> curr) {
        if (root == null) return;
        curr.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new LinkedList<Integer>(curr));
            curr.remove(curr.size() - 1); // note: need to remove here
            return;
        } else {
            helper(root.left, sum - root.val, result, curr);
            helper(root.right, sum - root.val, result, curr);
        }
        curr.remove(curr.size() - 1);
    }
}