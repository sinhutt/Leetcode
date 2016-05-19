public class Solution {
    /**
     * For example, if the input num[] is {1,2,3}: 
     * First, add 1 into the initial List<List<Integer>> (let's call it "answer").
     * Then, 2 can be added in front or after 1. So we have to copy the List in answer (it's just {1}), add 2 in position 0 of {1}, then copy the original {1} again, and add 2 in position 1. 
     * Now we have an answer of {{2,1},{1,2}}. There are 2 lists in the current answer.
     * Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0; then copy {2,1} and {1,2}, and add 3 into position 1, then do the same thing for position 3. 
     * Finally we have 2*3=6 lists in answer, which is what we want.
     */ 
    // iterative
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> rs = new ArrayList<>();
    //     if (nums.length == 0) return rs;
    //     List<Integer> curr = new ArrayList<Integer>();
    //     curr.add(nums[0]);
    //     rs.add(curr);
    //     for (int i = 1; i < nums.length; i++) {
    //         List<List<Integer>> newRS = new ArrayList<>();
    //         for (int j = 0; j <= i; j++) {
    //             for (List<Integer> l : rs) {
    //                 List<Integer> newL = new ArrayList<Integer>(l);
    //                 newL.add(j, nums[i]);
    //                 newRS.add(newL);
    //             }
    //         }
    //         rs = newRS;
    //     }
    //     return rs;
    // }
    
    // recursive
    // nums = 1,2,3

    // currIdx = 0, permutation = []
    // i = 0, newPermutation = [1]
    // currIdx = 1, permutation = [1]
    // i = 0, newPermutation = [2, 1]
    //     currIdx = 2, permutation = [2, 1]
    //     i = 0, newPermutation = [3, 2, 1]
    //     i = 1, newPermutation = [2, 3, 1]
    //     i = 2, newPermutation = [2, 1, 3]
    // i = 1, newPermutation = [1, 2]
    //     currIdx = 2, permutation = [1, 2]
    //     i = 0, newPermutation = [3, 1, 2]
    //     i = 1, newPermutation = [1, 3, 2]
    //     i = 2, newPermutation = [1, 2, 3]
        
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rs = new ArrayList<>();
        if (nums.length == 0) return rs;
        helper(rs, new ArrayList<Integer>(), 0, nums);
        return rs;
    }
    private void helper(List<List<Integer>> rs, List<Integer> permutation, int currIdx, int[] nums) {
        if (permutation.size() == nums.length) {
            rs.add(permutation);
            return;
        }
        for (int i = 0; i <= permutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<Integer>(permutation);
            newPermutation.add(i, nums[currIdx]);
            helper(rs, newPermutation, currIdx + 1, nums);
        }
    }
}