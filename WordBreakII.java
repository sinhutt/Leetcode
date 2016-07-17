public class Solution {
    
    // DFS solution: exceed time limit
    // public List<String> wordBreak(String s, Set<String> wordDict) {
    //     List<String> rs = new ArrayList<String>();
    //     helper(rs, "", s, wordDict, 0);
    //     return rs;
    // }
    
    // private void helper(List<String> rs, String curSentence, String s, Set<String> wordDict, int curr) {
    //     if (curr == s.length()) {
    //         rs.add(curSentence.trim());
    //         return;
    //     }
    //     for (int i = curr + 1; i <= s.length(); i++) {
    //         String word = s.substring(curr, i);
    //         if (wordDict.contains(word)) {
    //             String newCurSentence = curSentence + word + " ";
    //             helper(rs, newCurSentence, s, wordDict, i);
    //         }
    //     }
    // }
    
    // DFS + caching
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> rs = helper(s, wordDict, map);
        return rs;
    }
    
    private List<String> helper(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) 
            return map.get(s);
        
        LinkedList<String> rs = new LinkedList<String>();     
        if (s.length() == 0) {
            rs.add("");
            return rs;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = helper(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    String sentence = word + " " + sub;
                    sentence = sentence.trim();
                    rs.add(sentence);               
                }
            }  
        }
        map.put(s, rs);
        return rs;
    }
}