public class Solution {
    public void solve(char[][] board) {
        /**
         * The idea is based on the algorithm called "flood-fill".
         * We start from 0's on the four boundaries and use DFS/BFS to find all the reachable 0's and mark them as 1's.
         * After the traversal, the 0's that are left are the ones that are surrounded by X's. We scan the matrix to locate them.
         */ 
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row-1 || j == 0 || j == col-1) {
                    if (board[i][j]=='O') {
                        Queue<Integer> q = new LinkedList<Integer>();
                        board[i][j]='1';
                        q.add(i * col + j);
                        while (!q.isEmpty()) {
                            int cur = q.poll();
                            int x = cur / col;
                            int y = cur % col;
                            if (y + 1 < col && board[x][y+1] == 'O') {
                                q.add(cur+1);
                                board[x][y+1] = '1';
                            }
                            if (x + 1 < row && board[x+1][y] == 'O') {
                                q.add(cur+col);
                                board[x+1][y] = '1';
                            }
                            if (y - 1 >= 0 && board[x][y-1] == 'O') {
                                q.add(cur-1);
                                board[x][y-1] = '1';
                            }
                            if (x - 1 >= 0 && board[x-1][y] == 'O') {
                                q.add(cur-col);
                                board[x-1][y] = '1';
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}