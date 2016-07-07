public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos1 = -words.length, pos2 = words.length, rs = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) pos1 = i;
            else if (words[i].equals(word2)) pos2 = i;
            rs = Math.min(rs, Math.abs(pos1 - pos2));
        }
        return rs;
    }
}