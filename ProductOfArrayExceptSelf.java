public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        // find product of numbers to the left of nums[i]
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        
        int right = 1; // stores product of numbers to the right of the current num
        for (int i = n - 1; i>= 0; i--) {
            res[i] = res[i] * right;
            right *= nums[i];
        }
        
        return res;
    }
}