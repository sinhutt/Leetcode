/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    // the idea is same as using stack to do Binary Tree Inorder Traversal
    
    Stack<TreeNode> stack = null;
    TreeNode current = null;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || current != null;
    }

    /** @return the next smallest number */
    public int next() {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        TreeNode tmp = stack.pop();
        current = tmp.right;
        return tmp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */