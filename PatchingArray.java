public class Solution {
    /**
     * The variable max records the maximal value that can be formed by the elements in nums and patched numbers. 
     * If max is less than nums[i] - 1 which means we need to patch a new number, we then patch max + 1.
     * 
     * Example: Let's say the input is nums = [1, 2, 4, 13, 43] and n = 100. We need to ensure that all sums in the range [1,100] are possible.
     * Using the given numbers 1, 2 and 4, we can already build all sums from 0 to 7, i.e., the range [0,8). But we can't build the sum 8, and the next given number (13) is too large. So we insert 8 into the array. Then we can build all sums in [0,16).
     * Do we need to insert 16 into the array? No! We can already build the sum 3, and adding the given 13 gives us sum 16. We can also add the 13 to the other sums, extending our range to [0,29).
     * And so on. The given 43 is too large to help with sum 29, so we must insert 29 into our array. This extends our range to [0,58). But then the 43 becomes useful and expands our range to [0,101). At which point we're done.
     */ 
    public int minPatches(int[] nums, int n) {
        long max = 0;
        int cnt = 0, i = 0;
        while (max < n) {
            if (i >= nums.length || max + 1 < nums[i]) {
                max += max + 1;
                cnt++;
            } else {
                max += nums[i];
                i++;
            }
        }
        return cnt;
    }
}