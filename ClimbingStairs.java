public class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) return n;
        int[] cache = new int[n];
        // cache[i] corresponds to the number of ways to climb i+1 stairs
        cache[0] = 1;
        cache[1] = 2;
        for (int i = 2; i < n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }
        return cache[n-1];
    }
}