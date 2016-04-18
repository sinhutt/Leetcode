public class Solution {
    public int majorityElement(int[] nums) {
        /*
         * Boyer-Moore majority vote algorithm
         */
        int candidate = nums[0], counter = 0;
        for (int val : nums) {
            if (counter == 0) {
                candidate = val;
                counter = 1;
            } else if (val == candidate) {
                counter++;
            } else {
                counter--;
            }
        }

        /*
         * This verifies that the candidate satisfy the condition for being  
         * the majority element.
         */
        counter = 0;
        for (int val : nums) {
            if (val == candidate) counter++;
        }
        if (counter < (nums.length + 1) / 2) return -1;
        return candidate;
    }
}