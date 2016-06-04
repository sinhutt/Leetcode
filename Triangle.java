public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // The triangle has a tree-like structure, which would lead people to think about traversal algorithms such as DFS. However, if you look closely, you would notice that the adjacent nodes always share a 'branch'. In other word, there are overlapping subproblems. Also, suppose x and y are 'children' of k. Once minimum paths from x and y to the bottom are known, the minimum path starting from k can be decided in O(1), that is optimal substructure. Therefore, dynamic programming would be the best solution to this problem in terms of time complexity.
        // bottom-up DP, O(n) space, O(n^2) time, where n is the total number of rows in the triangle
        int[] dp = new int[triangle.size()];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                if (i == triangle.size() - 1)
                    dp[j] = triangle.get(i).get(j);
                else
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
        return dp[0];
    }
}