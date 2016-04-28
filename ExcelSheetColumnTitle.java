public class Solution {
    // can think of this as converting from base-10 to base-26
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n = n - 1; // note this
            result.insert(0, (char) ('A' + n % 26));
            n = n / 26;
        }
        return result.toString();
    }
}