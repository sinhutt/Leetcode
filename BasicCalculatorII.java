public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) 
                num = num * 10 + s.charAt(i) - '0';
            // i==s.length()-1 handles cases like "  5"
            if ((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i==s.length()-1) {
                if (sign == '-') stack.push(-num);
                if (sign == '+') stack.push(num);
                if (sign == '*') stack.push(stack.pop()*num);
                if (sign == '/') stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int rs = 0;
        for (int i : stack) {
            rs += i;
        }
        return rs;
    }
}
