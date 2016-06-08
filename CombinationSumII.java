public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        dfs(candidates, 0, target, new ArrayList<Integer>(), rs);
        return rs;
    }
    private void dfs(int[] candidates, int cur, int target, List<Integer> path, List<List<Integer>> rs) {
        if (target == 0) {
            rs.add(new ArrayList(path));
            return;
        }
        if (target < 0) return;
        for (int i = cur; i < candidates.length; i++){
            if (i > cur && candidates[i] == candidates[i-1]) continue; // avoid duplicates
            path.add(candidates[i]);
            dfs(candidates, i+1, target - candidates[i], path, rs);
            path.remove(path.size()-1);
        }
    }
}