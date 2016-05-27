public class Solution {
    public int lengthOfLIS(int[] nums) {
        // O(n^2), DP solution
        // https://www.youtube.com/watch?v=CE2b_-XfVDk
        if (nums.length <= 1) return nums.length;
        int[] T = new int[nums.length];
        for (int i = 0; i < T.length; i++) 
            T[i] = 1;
        for (int i = 1; i < T.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (T[j] + 1 > T[i])
                        T[i] = T[j] + 1;
                }
            }
        }
        int rs = 1;
        for (int i = 0; i < T.length; i++)
            rs = Math.max(rs, T[i]);
        return rs;
        
        // O(nlogn)
    }
}

count of smaller numbers after self
