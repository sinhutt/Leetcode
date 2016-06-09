public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";
        char[] sArray = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !vowels.contains(sArray[start] + ""))
                start++;
            while (start < end && !vowels.contains(sArray[end] + ""))
                end--;
            char tmp = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = tmp;
            start++;
            end--;
        }
        return new String(sArray);
    }
}
