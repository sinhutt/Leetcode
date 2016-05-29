public class Solution {
    public int singleNumber(int[] nums) {
        // Solution 1:
        // int ones = 0, twos = 0;
        // for(int i = 0; i < nums.length; i++){
        //     ones = (ones ^ nums[i]) & ~twos;
        //     twos = (twos ^ nums[i]) & ~ones;
        // }
        // return ones;
        
        // Solution 2:
        int[] bitCount = new int[32];
        for (int i = 0; i < 32; i++) {
            bitCount[i] = 0;
        }

        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            for (int i = 0; i < 32; i++) {
                boolean hasBit = (n & (1 << i)) != 0;
                if (hasBit) {
                    bitCount[i] = (bitCount[i] + 1) % 3;
                }
            }
        }

        int exept = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] > 0) {
                exept |= (1 << i);
            }
        }
        return exept;
    }
}
