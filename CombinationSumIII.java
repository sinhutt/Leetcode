public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // backtracking
        List<List<Integer>> rs = new ArrayList<>();
        combination(rs, new ArrayList<Integer>(), k, 1, n);
        return rs;
    }
    /**
     * curr: current combination of numbers
     * currNum: next distinct number to try to add to curr so that the sum of numbers in curr is the original n
     * n: the remaining sum 
     */
    private void combination(List<List<Integer>> rs, List<Integer> curr, int k, int currNum, int n) {
        if (curr.size() > k) return;
        if (curr.size() == k && n == 0) {
            List<Integer> ans = new ArrayList<Integer>(curr);
            rs.add(ans);
            return;
        }
        // we start trying from the smallest number available 1, 2, ..., till 9
        for (int i = currNum; i <= n && i <= 9; i++) {
            curr.add(i);
            combination(rs, curr, k, i + 1, n - i);
            curr.remove(curr.size() - 1);
        }
    }
}