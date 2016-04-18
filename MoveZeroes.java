public class Solution {
    public void moveZeroes(int[] nums) {
        /*
         * zero: keeps track of the start of all the zeroes
         * Basically, this algorithm goes through the array.
         * When we find a non-zero element, we swap it with the start of the zeroes,
         * and increment the start of all zeroes by 1.
         */
        int i = 0, zero = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = tmp;
                zero++;
            }
            i++;
        }
    }
}