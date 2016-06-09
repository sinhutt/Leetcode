public class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
         * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values  
         * keep two pointers which define the max substring
         * move the right pointer to scan through the string, and meanwhile update the hashmap
         * if the character is already in the hashmap, then move the left pointer to the right of the same character last found 
         */ 
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, i = 0, j = 0; // j: left pointer, i: right pointer
        while (i < s.length()) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
            i++;
        }
        return max;
    }
}