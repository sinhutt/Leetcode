public class Solution {
    public int countComponents(int n, int[][] edges) {
        // union-find solution
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = find(roots, edge[0]);
            int root2 = find(roots, edge[1]);
            if (root1 != root2) {
                roots[root1] = root2; // union
                n--;
            }
        }
        return n;
    }
    
    private int find(int[] roots, int id) {
        while (roots[id] != id) {
            roots[id] = roots[roots[id]]; // path compression
            id = roots[id];
        }
        return id;
    }
}