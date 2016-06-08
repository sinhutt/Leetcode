public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return res;
        helper(res, new ArrayList<String>(), s);
        return res;
    }

    public void helper(List<List<String>> res, List<String> cur, String s){
        if (s.length() == 0) {
            res.add(new ArrayList<String>(cur));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i+1))) {
                cur.add(s.substring(0, i+1));
                helper(res, cur, s.substring(i+1));
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        for (int i=0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) 
                return false;
        }
        return true;
    }
}