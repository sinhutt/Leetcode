public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // Backtracking
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        helper(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    
    public static void helper(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start;i <= n;i++) {
            comb.add(i);
            helper(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}