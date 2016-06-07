public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res); // start with putting Q in the 0th col
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        // base case
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        // recursive case
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) { // no need to check beyond col y, b/c no Q has been placed beyond that col
                // x == i checks if there's a Q in the same row
                // x + j == y + i || x + y == i + j is the same as x - i == y - j || x - i = j = y
                // this checks if there's a Q diagonally
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}