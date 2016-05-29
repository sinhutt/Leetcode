public class Solution {
    public int lengthOfLIS(int[] nums) {
        // O(n^2), DP solution
        // if (nums.length <= 1) return nums.length;
        // int[] T = new int[nums.length];
        // for (int i = 0; i < T.length; i++) 
        //     T[i] = 1;
        // for (int i = 1; i < T.length; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] < nums[i]) {
        //             if (T[j] + 1 > T[i])
        //                 T[i] = T[j] + 1;
        //         }
        //     }
        // }
        // int rs = 1;
        // for (int i = 0; i < T.length; i++)
        //     rs = Math.max(rs, T[i]);
        // return rs;
        
        // O(nlogn)
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }
}

// similar to "count of smaller numbers after self"
