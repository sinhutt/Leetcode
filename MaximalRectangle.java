public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        for (int j = 0; j < n; j++) right[j] = n;
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            int curL = 0, curR = n;
            for (int j = 0; j < n; j++) { // compute height (can do this from left or right side)
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) { // compute left (must do this from left to right)
                if (matrix[i][j] == '1') left[j] = Math.max(left[j], curL);
                else {
                    left[j] = 0;
                    curL = j + 1;
                }
            }
            for (int j = n-1; j >= 0; j--) { // compute right (must do this from right to left)
                if (matrix[i][j] == '1') right[j] = Math.min(right[j], curR);
                else {
                    right[j] = n;
                    curR = j;
                }
            }
            for (int j = 0; j < n; j++) { // compute area of rectangle (can do this from left or right side)
                maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
            }
        }
        return maxArea;
    }
}
