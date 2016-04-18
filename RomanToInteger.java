public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        s = s.trim();
        char[] sc = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < sc.length - 1; i++) {
            int current = valueForRoman(sc[i]);
            int next = valueForRoman(sc[i+1]);
            if (current < next) sum -= current;
            else sum += current;
        }
        sum += valueForRoman(sc[sc.length-1]);
        return sum;
    }
    
    private int valueForRoman(char c) {
        // I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}