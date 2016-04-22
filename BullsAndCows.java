public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] counts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) bull++;
            else {
                if (counts[s] < 0) cow++; // this char in secret has already appreared in guess
                if (counts[g] > 0) cow++; // this char in guess has already appeared in secret
                counts[s]++;
                counts[g]--;
            }
        }
        return bull + "A" + cow + "B";
    }
}