public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // treat it as a sorted array, and use binary search
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l != r) {
            int mid = (l + r) / 2;
            if (matrix[mid / n][mid % n] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return matrix[r / n][r % n] == target;
    }
}