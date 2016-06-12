public class Solution {
    // Traverse one pass with two pointers, from two sides to the middle.
    public int trap(int[] height) {
        int rs = 0;
        if (height.length < 3) return 0;
        int l = 0, r = height.length - 1;
        
        // find the left and right edge which can hold water
        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;
        
        while (l < r) {
            int lHeight = height[l];
            int rHeight = height[r];
            if (lHeight <= rHeight) {
                while (l < r && lHeight >= height[++l]) {
                    rs += lHeight - height[l];
                }
            } else {
                while (l < r && rHeight >= height[--r]) {
                    rs += rHeight - height[r];
                }
            }
        }
        return rs;
    }
}

