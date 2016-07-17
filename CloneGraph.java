/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap <UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode newNode = helper(node, map);
        return newNode;
    }
    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode;
        if (!map.containsKey(node)) {
            newNode = new UndirectedGraphNode(node.label);
            map.put(node, newNode);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                newNode.neighbors.add(helper(neighbor, map));
            }
        } else {
            newNode = map.get(node);
        }
        return newNode;
    }
}