In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.

public class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1:
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Two's complement of a given number has all the bits reverted except for the rightmost digit
        // So this gets the last set bit
        diff = diff & (-diff); 
        
        // Pass 2:
        int[] results = {0, 0};
        for (int num : nums) {
            // general note: always put () around binary operations
            if ((num & diff) == 0) { // the bit is not set
                results[0] ^= num;
            } else { // the bit is set
                results[1] ^= num;
            }
        }
        return results;
    }
}