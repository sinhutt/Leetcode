public class Solution {
    Map<Character, String> map = new HashMap<Character, String>();
    public boolean wordPatternMatch(String pattern, String str) {
        if (pattern.length() == 0) return str.length() == 0;
        if (map.containsKey(pattern.charAt(0))) {
            String value = map.get(pattern.charAt(0));
            if (str.length() < value.length() || !str.substring(0, value.length()).equals(value))
                return false;
            if (wordPatternMatch(pattern.substring(1), str.substring(value.length())))
                return true;
        } else {
            for (int i = 1; i <= str.length(); i++) { // note the equal sign here in i <= str.length()
                String value = str.substring(0, i);
                if (map.containsValue(value)) continue;
                map.put(pattern.charAt(0), value);
                if (wordPatternMatch(pattern.substring(1), str.substring(value.length())))
                    return true;
                map.remove(pattern.charAt(0)); // note syntax for removing an entry from map
            }
        }
        return false;
    }
}