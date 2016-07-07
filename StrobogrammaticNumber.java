public class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null) return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int l = 0, r = num.length() - 1;
        while (l < r) {
            // only map.get(num.charAt(l)), not map.get(num.charAt(r))
            // otherwise: NullPpointerException
            if (!map.containsKey(num.charAt(l)) || num.charAt(r) != map.get(num.charAt(l))) 
                return false;
            l++;
            r--;
        }
        return (l > r || num.charAt(l) == '0' || num.charAt(l) == '1' || num.charAt(l) == '8');
    }
}