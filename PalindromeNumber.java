public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        // reverse is the second half of x reversed
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }
        return (x == reverse || x == reverse / 10);
    }
}