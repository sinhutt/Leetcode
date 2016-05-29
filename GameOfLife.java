public class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        
        // we use decoding to represent temp state:
        // 0: current state = 0, next state = 0;
        // 1: current state = 1, next state = 1;
        // 2: current state = 1, next state = 0;
        // 3: current state = 0, next state = 1;
        // after marking each point, we decode the states by mod 2
        int m = board.length;
        int n = board[0].length;
        
        // process the board and mark the states
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;
                for (int x = Math.max(i-1, 0); x <= Math.min(i+1, m-1); x++) {
                    for (int y = Math.max(j-1, 0); y <= Math.min(j+1, n-1); y++) {
                        if (x != i || y != j)
                            lives += board[x][y] == 1 || board[x][y] == 2 ? 1 : 0; 
                            // count neighboring cells with current state = 1
                    }
                }
                // update state for cell(i, j)
                // the only live to dead case is when lives < 2 or lives > 3
                // note: no need to consider the case of 10 --> 10, b/c no change, 
                // only need to consider the case of 11 --> 10
                if (board[i][j] == 1 && (lives < 2 || lives > 3))
                    board[i][j] = 2;
                // the only dead to live case is when lives == 3
                // note: no need to consider the case of 01 --> 01, b/c no change
                // only need to consider the case of 00 --> 01
                if (board[i][j] == 0 && lives == 3)
                    board[i][j] = 3;
            }
        }
        // decode to get the next state of each cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2; 
            }
        }
    }
}


