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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (root == null) return rs;
        List<Integer> list = new ArrayList<Integer>();
        LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currLevel.add(root);
        boolean needReverse = false;
        while (!currLevel.isEmpty()) {
            TreeNode node = currLevel.remove();
            list.add(node.val);
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
            if (currLevel.isEmpty()) {
                if (needReverse) Collections.reverse(list);
                needReverse = !needReverse;
                rs.add(list);
                currLevel = nextLevel;
                nextLevel = new LinkedList<TreeNode>();
                list = new ArrayList<Integer>();
            }
        }
        return rs;
    }
}