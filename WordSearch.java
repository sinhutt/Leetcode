public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, w, 0)) return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int i, int j, char[] w, int cur) {
        if (cur == w.length) return true;
        if (i < 0 || j < 0 || i > board.length -1 || j > board[0].length - 1) return false;
        if (board[i][j] != w[cur]) return false;
        board[i][j] = '*';
        boolean exist = helper(board, i, j + 1, w, cur + 1)
                        || helper(board, i, j -1, w, cur + 1)
                        || helper(board, i + 1, j, w, cur + 1)
                        || helper(board, i - 1, j, w, cur + 1);
        board[i][j] = w[cur];
        return exist;
    }
}

