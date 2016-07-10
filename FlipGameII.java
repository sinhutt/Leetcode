public class Solution {
    public boolean canWin(String s) {
        // Backtracking solution
        /**
         * We can basically try every possible move for the first player (Let's call him 1P from now on), 
         * and recursively check if the second player 2P has any chance to win. 
         * If 2P is guaranteed to lose, then we know the current move 1P takes must be the winning move.
         */ 
        for (int i = 0; i <= s.length() - 2; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                s = s.substring(0, i) + "--" + s.substring(i+2);
                boolean win = !canWin(s);
                if (win) return true;
                s = s.substring(0, i) + "++" + s.substring(i+2);
            }
        }
        return false;
    }
}