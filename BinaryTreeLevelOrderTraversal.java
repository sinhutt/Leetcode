/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// DFS
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
        addLevel(list, 0, root);
        return list;
    }

    private void addLevel(LinkedList<List<Integer>> list, int level, TreeNode node) {
        if (node == null) return;
        if (list.size()-1 < level) list.add(new LinkedList<Integer>());
        list.get(level).add(node.val);
        addLevel(list, level+1, node.left);
        addLevel(list, level+1, node.right);
    }
}

// BFS
// public class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();
//         if (root == null) return list;
//         Queue<TreeNode> queue = new LinkedList<TreeNode>();
//         queue.offer(root);
//         while (!queue.isEmpty()) {
//             int levelNum = queue.size(); // num elements at that level
//             List<Integer> levelList = new LinkedList<Integer>(); // list of elements at that level
//             for (int i = 0; i < levelNum; i++) {
//                 TreeNode cur = queue.poll();
//                 if (cur.left != null) queue.offer(cur.left);
//                 if (cur.right != null) queue.offer(cur.right);
//                 levelList.add(cur.val);
//             }
//             list.add(levelList);
//         }
//         return list;
//     }
// }