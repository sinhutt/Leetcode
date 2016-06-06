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
     * Note that 1..n is the in-order traversal for any BST with nodes 1 to n. 
     * So if I pick i-th node as my root, the left subtree will contain elements 1 to (i-1), 
     * and the right subtree will contain elements (i+1) to n. 
     * I use recursive calls to get back all possible trees for left and right subtrees 
     * and combine them in all possible ways with the root.
     */ 
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return helper(1, n);
    }
    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (start > end) {
            list.add(null);
            return list;
        }
        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = helper(start, i-1);
            right = helper(i+1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}