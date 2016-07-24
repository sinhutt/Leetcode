public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || s.length() < t.length()) 
            return "";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) 
                map.put(c, map.get(c) + 1);
            else 
                map.put(c, 1);
        }
        int left = 0, count = 0;
        int minLeft = 0, minLen = s.length() + 1;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) >= 0) count++; // we might have t containing "a", but s containing "aa"
                while (count == t.length()) {
                    int len = right - left + 1;
                    if (len < minLen) {
                        minLen = len;
                        minLeft = left;
                    }
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) > 0) count--; // same reasoning as above
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) return "";
        return s.substring(minLeft, minLeft + minLen);
    }
}

