public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = words.length, pos1 = -words.length, pos2 = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                pos1 = i;
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) 
                    pos1 = pos2;
                pos2 = i;
            }
            dist = Math.min(dist, Math.abs(pos1 - pos2));
        }
        return dist;
    }
}