public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> cache = new HashSet<Integer>();
        while (true) {
            if (cache.contains(n)) break;
            cache.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }
            if (sum == 1) return true;
            else n = sum;
        }
        return false;
    }
}