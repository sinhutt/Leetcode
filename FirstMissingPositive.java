public class Solution {
    public int firstMissingPositive(int[] nums) {
        /**
         * Rule of thumb: given an unsorted array with linear time requirements, a hashtable is usually used.
         * Since we are also required to use only constant space, we use the array itself as a hastable,
         * i.e. we place each entry x to nums[x-1].
         * If nums[i] != i+1, then we move it to the correct position nums[nums[i]-1].
         * There are 2 possibilities after the swap:
         * 1. The newly swapped element nums[nums[i]-1] might still be out of place. so we cannot increment i.
         * 2. nums[i] == nums[nums[i]-1]. We will keep swapping forever. Thus, we need to check this before we swap.
         */ 
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= 1 && nums[i] <= nums.length && 
                    nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}