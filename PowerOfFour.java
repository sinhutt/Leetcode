public class Solution {
    public boolean isPowerOfFour(int num) {
        // iterative
        // if (num <= 0) return false;
        // if (num == 1) return true;
        // while (num % 4 == 0) {
        //     num = num / 4;
        //     if (num == 1) return true;
        // }
        // return false;
        
        // recursive
        return (num == 1) || ((num > 0) && (num%4 == 0) && (isPowerOfFour(num/4)));
        
        // no loop, no recursion
        // 0x55555555 is to get rid of those power of 2 but not power of 4
        // so that the single 1 bit always appears at the odd position
        // return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
    }
}