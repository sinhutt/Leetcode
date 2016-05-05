public class Solution {
    public int myAtoi(String str) {
        int index = 0, total = 0, sign = 1;
        
        // 1. Empty String
        if (str.length() == 0) return 0;
        
        // 2. Remove spaces
        while (index < str.length() && str.charAt(index) == ' ') 
            index++;
        
        // 3. Handle signs
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+'? 1 : -1;
            index++;
        }
        
        // 4. Convert number and avoid overflow
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            // Handle non-numerical character or space
            if (digit < 0 || digit > 9) break;
            // Handle overflow
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && digit > Integer.MAX_VALUE % 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            total = total * 10 + digit;
            index++;
        }
        return total * sign;
    }
}