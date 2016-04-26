public class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            // handles cases where the reversed integer might overflow
            if ((newResult - tail) / 10 != result) return 0; 
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}