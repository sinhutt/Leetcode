public class Solution {

    /*
     * Assumes ASCII characters only, i.e. 128 characters in total
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        int[] ascii = new int[128];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (char c : sc) {
            ascii[c]++;
        }
        for (char c : tc) {
            if (ascii[c] > 0) {
                ascii[c]--;
            } else {
                return false;
            }
        }
        return true;
    }
    
    /*
     * Unicode characters
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return (new String(sc).equals(new String(tc)));
    }
    
}