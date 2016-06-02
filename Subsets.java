public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List<Integer> prev : res) {
                List<Integer> curr = new ArrayList<>(prev);
                curr.add(num);
                tmp.add(curr);
            }
            res.addAll(tmp);
        } 
        return res;
    }
}