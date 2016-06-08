public class Solution {
    /**
     * Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
     * Sort the array "int[] nums" to make sure we can skip the same value.
     * When a number has the same value with its previous, we can use this number only if his previous is used.
     */ 
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return rs;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, used, new ArrayList<Integer>(), rs);
        return rs;
    }
    private void dfs(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> rs) {
        if (cur.size() == nums.length) {
            rs.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue; // handles duplicates case
            used[i] = true;
            cur.add(nums[i]);
            dfs(nums, used, cur, rs);
            used[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
