public class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int diffCol = k * (k-1);
        int sameCol = k;
        for (int i = 2; i < n; i++) {
            int tmp = diffCol;
            diffCol = (diffCol + sameCol) * (k - 1);
            sameCol = tmp;
        }
        return diffCol + sameCol;
    }
}