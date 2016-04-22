public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // using array
        // boolean[][] row = new boolean[9][9];
        // boolean[][] col = new boolean[9][9];
        // boolean[][] cube = new boolean[9][9];
        
        // for (int i = 0; i < 9; i++) {
        //     for (int j = 0; j < 9; j++) {
        //         if (board[i][j] == '.') continue;
        //         int c = board[i][j] - '1';
        //         if (row[i][c] || col[c][j] || cube[i/3*3 + j/3][c]) return false;
        //         row[i][c] = col[c][j] = cube[i/3*3 + j/3][c] = true;
        //     }
        // }
        // return true;
        
        // using set
        for (int i = 0; i < 9; i++) {
            if (!isPartiallyValid(board, i, 0, i, 8)) return false;
            if (!isPartiallyValid(board, 0, i, 8, i)) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isPartiallyValid(board, i*3, j*3, i*3+2, j*3+2)) return false;
            }
        }
        return true;
    }
    
    private boolean isPartiallyValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set<Character> set = new HashSet<Character>();
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] == '.') continue;
                if (!set.add(board[i][j])) return false;
            }
        }
        return true;
    }
}