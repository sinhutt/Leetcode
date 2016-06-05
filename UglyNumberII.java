public class Solution {
    public int nthUglyNumber(int n) {
        int[] rs = new int[n];
        rs[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            rs[i] = min;
            // note: cannot use else if here
            // b/c need to update the index for all factors
            if (factor2 == min) {
                index2++;
                factor2 = 2 * rs[index2];
            }
            if (factor3 == min) {
                index3++;
                factor3 = 3 * rs[index3];
            }
            if (factor5 == min) {
                index5++;
                factor5 = 5 * rs[index5];
            }
        }
        return rs[n-1];
    }
}