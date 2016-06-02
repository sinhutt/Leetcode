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
    // using stack, O(log(n)) time, O(n) space
    // public void flatten(TreeNode root) {
    //     if (root == null) return;
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     stack.push(root);
    //     while (!stack.isEmpty()) {
    //         TreeNode curr = stack.pop();
    //         if (curr.right != null)
    //             stack.push(curr.right);
    //         if (curr.left != null)
    //             stack.push(curr.left);
    //         if (!stack.isEmpty()) 
    //             curr.right = stack.peek();
    //         curr.left = null;
    //     }
    // }


   //      1
   //  /       \
   // 2         5
   //  \         \
   //   3         6 <- rightTail
   //    \
   //     4 <- leftTail


    // given a node, suppose that its left subtree and right subtree have both been flattened
    // as shown in the tree above,

    // temp = root.right
    // root.right = root.left
    // root.left = null
    // leftTail.right = temp

    public void flatten(TreeNode root) {
        root = helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTail = helper(root.left);
        TreeNode rightTail = helper(root.right);
        if (leftTail != null) {
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            leftTail.right = tmp;
        }
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return root;
    }
}