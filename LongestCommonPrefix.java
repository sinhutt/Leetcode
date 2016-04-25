public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // sort the array
        // if (strs == null) return null;
        // if (strs.length == 0) return "";
        
        // Arrays.sort(strs);
        // char[] first = strs[0].toCharArray();
        // char[] last = strs[strs.length - 1].toCharArray();
        
        // int i = 0;
        // int len = Math.min(first.length, last.length);
        // while (i < len && first[i] == last[i]) {
        //     i++;
        // }
        // return strs[0].substring(0, i);
        
        // using indexOf
        if (strs == null) return null;
        if (strs.length == 0) return "";
        
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length()-1);
            }
            i++;
        }
        return pre;
    }
}