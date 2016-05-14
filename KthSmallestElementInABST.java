/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// Binary Search (DFS) --> best
// public class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         int count = countNodes(root.left);
//         if (k <= count) {
//             return kthSmallest(root.left, k);
//         } else if (k > count + 1) {
//             return kthSmallest(root.right, k - count - 1);
//         }
//         return root.val;
//     }
    
//     private int countNodes(TreeNode node) {
//         if (node == null) return 0;
//         return 1 + countNodes(node.left) + countNodes(node.right);
//     }
// }

// DFS recursive
// public class Solution {
//     private static int number = 0;
//     private static int count = 0;

//     public int kthSmallest(TreeNode root, int k) {
//         count = k;
//         helper(root);
//         return number;
//     }

//     public void helper(TreeNode n) {
//         if (n.left != null) helper(n.left);
//         count--;
//         if (count == 0) {
//             number = n.val;
//             return;
//         }
//         if (n.right != null) helper(n.right);
//     }
// }

// DFS iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        while (k != 0) {
            TreeNode n = stack.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1; // never hit if k is valid
    }
}

