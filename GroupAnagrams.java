public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) 
            return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
