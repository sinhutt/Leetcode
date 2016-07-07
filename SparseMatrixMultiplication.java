public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, Bn = B[0].length;
        int[][] C = new int[m][Bn];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < Bn; j++) {
                for (int k = 0; k < n; k++) {
                    if (A[i][k] != 0 && B[k][j] != 0)
                        C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}