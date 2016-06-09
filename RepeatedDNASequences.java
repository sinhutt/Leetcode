public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        /**
         * idea: get all the possible 10 letter long sequences and put them into completeSet
         * if the operation failed, it means there are duplicates, so put the sequence into another rsSet
         * finally, add all the rsSet to the final rs list.
         */ 
        List<String> rs = new ArrayList<String>();
        Set<String> rsSet = new HashSet<String>();
        if (s == null || s.length() <= 10) {
            return rs;
        }
        Set<String> completeSet = new HashSet<String>();
        int len = s.length();
        for (int i = 0; i <= len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!completeSet.add(sub)) {
                rsSet.add(sub);
            }
        }
        rs.addAll(rsSet);
        return rs;
    }
}