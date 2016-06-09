public class Solution {
    private int lo, maxLen;
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i); // assume max palindrome is odd length
            extendPalindrome(s, i, i+1); // assume max palindrome is even length
        }
        return s.substring(lo, lo + maxLen);
    }
    // extend the palindrome from start (inclusive) to end (inclusive) as far as possible
    private void extendPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        start++;
        end--;
        if (maxLen < end - start + 1) {
            lo = start;
            maxLen = end - start + 1;
        }
    }
}

