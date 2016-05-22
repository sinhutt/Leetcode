// 2 4 1 5 8 3

// 2, 3 --> 6
// 4, 3 --> 12
// 4, 8 --> 32
// 1, 8 --> 32
// 5, 8 --> 40


public class Solution {
    public int maxArea(int[] height) {
        /**
         * Set two pointers initialized at both ends of the array. 
         * Every time move the smaller value pointer to inner array. 
         * Then after the two pointers meet, all possible max cases have been scanned and the max situation is 100% reached somewhere in the scan
         */
         int left = 0, right = height.length - 1, rs = 0;
         while (left < right) {
             rs = Math.max(rs, Math.min(height[left], height[right]) * (right - left));
             if (height[left] <= height[right]) left++;
             else right--;
         }
         return rs;
    }
}