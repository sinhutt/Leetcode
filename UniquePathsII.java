public class Solution {
    // DP, modifies the original grid
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int row = obstacleGrid.length;
    //     int col = obstacleGrid[0].length;
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
    //             else if (i == 0 && j == 0) obstacleGrid[i][j] = 1;
    //             else if (i == 0) obstacleGrid[i][j] = obstacleGrid[i][j-1];
    //             else if (j == 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
    //             else obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
    //         }
    //     }
    //     return obstacleGrid[row-1][col-1];
    // }
    
// obstacleGrid:
// 0 0 1 0 0
// 0 0 0 0 0

// dp:
// row 1: 1 1 0 0 0
// row 2: 0 2 2 2 2

    // DP, without modifying the original grid
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1; // first column: always 1
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) dp[j] = 0;
                else if (j > 0) // no need to update first column
                    dp[j] += dp[j-1];
            }
        }
        return dp[width-1];
    }
}