public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> curr, int pos, int[] nums) {
        res.add(curr);
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i-1]) continue;
            // need to create a new ArrayList, b/c we do not want to modify curr
            List<Integer> newCurr = new ArrayList<Integer>(curr);
            newCurr.add(nums[i]);
            helper(res, newCurr, i+1, nums);
            // note: no need to remove nums[i] from newCurr
        }
    }
}

