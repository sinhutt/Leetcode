public class Solution {
    // DFS
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        helper("", list, n, n);
        return list;
    }
    private void helper(String cur, List<String> list, int left, int right) {
        if (left > right) return;
        if (left > 0)
            helper(cur + "(", list, left - 1, right);
        if (right > 0)
            helper(cur + ")", list, left, right - 1);
        if (left == 0 && right == 0) {
            list.add(cur);
            return;
        }
    }
}