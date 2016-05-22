public class Solution {
    public void setZeroes(int[][] matrix) {
        // use fr, fc respectively to track if the first row or col should be set to 0
        // store info about zero rows and zero cols in first row and first col of matrix
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
    }
}