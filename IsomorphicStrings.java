public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // using HashMap
        if (s == null != s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) == c2) continue;
                else return false;
            } else {
            	// need to have this to handle the case where c2 is being mapped by another char
                if (map.containsValue(c2)) return false; 
                else map.put(c1, c2);
            }
        }
        return true;
        
        // w/o HashMap
        // int[] m1 = new int[256];
        // int[] m2 = new int[256];
        // for (int i = 0; i < s.length(); i++) {
        //     if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
        //     m1[s.charAt(i)] = i + 1;
        //     m2[t.charAt(i)] = i + 1;
        //     // note: need to add 1, b/c int[] is initialized to be all 0
        //     // w/o + 1, e.g. "ab", "aa" will return true --> wrong
        // }
        // return true;
    }
}