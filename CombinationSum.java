public class Solution {
    // iterative
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     // sort candidates to try them in asc order
    //     Arrays.sort(candidates); 
    //     List<List<List<Integer>>> dp = new ArrayList<>();
        
    //     // run through all targets from 1 to t
    //     for (int i = 1; i <= target; i++) { 
    //         List<List<Integer>> newList = new ArrayList(); // combinations for curr target
    //         // run through all candidates <= i
    //         for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
    //             // special case when curr target is equal to curr candidate
    //             if (i == candidates[j]) 
    //                 newList.add(Arrays.asList(candidates[j]));
    //             // if current candidate is less than the target, use prev results
    //             else {
    //                 for (List<Integer> l : dp.get(i-candidates[j]-1)) {
    //                     if (candidates[j] <= l.get(0)) {
    //                         List cl = new ArrayList<>();
    //                         cl.add(candidates[j]); 
    //                         cl.addAll(l);
    //                         newList.add(cl);
    //                     }
    //                 }
    //             }
    //         }
    //         dp.add(newList);
    //     }
    //     return dp.get(target-1);
    // }
    
    // recursive
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), candidates, 0, target);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> curr, int[] candidates, int pos, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                curr.add(candidates[i]);
                helper(result, curr, candidates, i, target - candidates[i]); // note: i, not i+1
                curr.remove(curr.size() - 1);
            }
        }
    }
}