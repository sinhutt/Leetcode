public class Solution {
    // Recursive Solution
    // public boolean isMatch(String s, String p) {
    //     if (p == null || p.length() == 0) return s == null || s.length() == 0;
         
    //     // Case 1: p.length() == 1
    //     if (p.length() == 1) {
    //         if (s == null || s.length() == 0) return false;
    //         if (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')
    //             return false;
    //         return isMatch(s.substring(1), p.substring(1));
    //     }
         
    //     // Case 2: p.charAt(1) != '*'
    //     if (p.charAt(1) != '*') {
    //         if (s.length() == 0) return false;
    //         if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
    //             return isMatch(s.substring(1), p.substring(1));
    //         else 
    //             return false;
    //     } else { // Case 3: p.charAt(1) == '*'
    //         if (isMatch(s, p.substring(2))) return true; // 0 occurrences
    //         int i = 0; // >= 1 occurrences
    //         while (i < s.length() && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')) {
    //             if (isMatch(s.substring(i + 1), p.substring(2))) 
    //                 return true;
    //             i++;
    //         }
    //         return false;
    //     }
    // }
    
    // DP Solution
    // 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    // 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    // 3, If p.charAt(j) == '*': 
    // here are two sub conditions:
    //           1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    //           2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    //                           dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
    //                       or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    //                       or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}