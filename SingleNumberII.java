public class Solution {
	/**
	 * Write all numbers in binary form, then for any bit 1 that appeared 3*n times (n is an integer), 
	 * the bit can only present in numbers that appeared 3 times.
	 * e.g. 0010 0010 0010 1011 1011 1011 1000 (assuming 4-bit integers) 2(0010) and 11(1011) appeared 3 times, and digit counts are:
	 * Digits 3 2 1 0
 	 * Counts 4 0 6 3
     * Counts%3 1 0 0 0
	 * Counts on 2,1,0 are all times of 3, the only digit index that has Counts % 3 != 0 is 3
	 * Therefore, to find the number that appeared only 1 or 2 times, we only need to extract all bits that has Counts %3 != 0
	 */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}