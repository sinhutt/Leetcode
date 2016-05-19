public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] rs = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int count = 1;
        while (left <= right) {
            for (int j = left; j <= right; j++) {
                rs[top][j] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                rs[i][right] = count;
                count++;
            }
            right--;
            for (int j = right; j >= left; j--) {
                rs[bottom][j] = count;
                count++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                rs[i][left] = count;
                count++;
            }
            left++;
        }
        return rs;
    }
}