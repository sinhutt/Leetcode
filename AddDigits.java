public class Solution {
    public int addDigits(int num) {
        /*
         * 10^k % 9 = 1
         * a*10^k % 9 = a % 9 
         * e.g. x = 23456
         * x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6
         * 2 * 10000 % 9 = 2 % 9
         * 3 * 1000 % 9 = 3 % 9
         * 4 * 100 % 9 = 4 % 9
         * 5 * 10 % 9 = 5 % 9
		 * Then x % 9 = ( 2+ 3 + 4 + 5 + 6) % 9, note that x = 2* 10000 + 3 * 1000 + 4 * 100 + 5 * 10 + 6
		 * So we have 23456 % 9 = (2 + 3 + 4 + 5 + 6) % 9
         */
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}