public class Solution {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
            if (map.get(c) % 2 == 0) odd--;
            else odd++;
        }

        // cannot form any palindromic string
        List<String> rs = new ArrayList<String>();
        if (odd > 1) return rs;

        // step 2. add half count of each character to list
        String mid = "";
        List<Character> list = new ArrayList<Character>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val / 2; i++) list.add(key);
        }

        // step 3. generate all the permutations
        boolean[] used = new boolean[list.size()];
        getPerm(list, mid, used, new StringBuilder(), rs);
        return rs;
    }

    // generate all unique permutation from list
    private void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> rs) {
        if (sb.length() == list.size()) {
            rs.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true; sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb, rs);
                // backtracking
                used[i] = false; sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}