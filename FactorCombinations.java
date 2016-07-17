public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (n < 2) return rs;
        helper(rs, new ArrayList<Integer>(), n, 2);
        return rs;
    }
    
    private void helper(List<List<Integer>> rs, List<Integer> currList, int n, int start) {
        if (n == 1) {
            if (currList.size() > 1) {
                rs.add(new ArrayList<Integer>(currList));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                currList.add(i);
                helper(rs, currList, n / i, i);
                currList.remove(currList.size() - 1);
            }
        }
    }
}