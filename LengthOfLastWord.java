public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim(); // removes leading the trailing white spaces
        int lastIndex = s.lastIndexOf(' ') + 1; // if there's no space, we get 0
        return s.length() - lastIndex;
    }
}