public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> rs = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.chatAt(i) - offset);
                if (c < 'a') c = c + 26;
                key += c;
            }
            if (!map.contains(key)) {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }
        }
        for (String str : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            rs.add(list);
        }
        return rs;
    }
}