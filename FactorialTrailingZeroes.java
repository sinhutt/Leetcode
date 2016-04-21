public class Solution {
    public int trailingZeroes(int n) {
        /*
         * Multiples of 5 provide one 5, multiples of 25 provide two 5, and so on.
         * Note: multiples of 25 is also multiple of 5, so multiple of 25 only provide one extra 5.
         * return n/5 + n/25 + n/125 + n/625 + ...;
         */
        // iterative
        // int count = 0;
        // while (n > 0) {
        //     count += n / 5;
        //     n = n / 5;
        // }
        // return count;
        
        // recursive
        if (n == 0) return 0;
        return (n / 5) + trailingZeroes(n / 5); 
    }
}