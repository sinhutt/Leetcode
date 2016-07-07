public class ValidWordAbbr {
    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for (String str : dictionary) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(str))
                    map.put(key, "");
            } else {
                map.put(key, str);
            }
        }
    }
    
    private String getKey(String str) {
        if (str.length() <= 2) return str;
        return str.charAt(0) + Integer.toString(str.length()-2) + str.charAt(str.length()-1);
    }
    
    public boolean isUnique(String word) {
        String key = getKey(word);
        if (!map.containsKey(key) || map.get(key).equals(word)) return true;
        return false;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");