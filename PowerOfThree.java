public class Solution {
    public boolean isPowerOfThree(int n) {
        // iterative
        // if (n <= 0) return false;
        // if (n == 1) return true;
        // while (n % 3 == 0) {
        //     n = n / 3;
        //     if (n == 1) return true;
        // }
        // return false;
        
        // recursive
        // return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
        
        // no loop, no recursion
        // max positive 32-bit int is 0x7fffffff, i.e. 2^31
        // to find the max 32-bit power of 3, i.e. find max x such that (2^31)/(3^x) >= 1
        // log(2^31) >= x*log3, i.e. x <= log(2^31)/log(3)
        int maxPowerOfThree = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        return (n > 0) && (maxPowerOfThree % n==0);
    }
}