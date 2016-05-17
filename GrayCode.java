public class Solution {
    public List<Integer> grayCode(int n) {
        /**
         * generate the sequence iteratively. 
         * For example, when n=3, we can get the result based on n=2. 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). 
         * The middle two numbers only differ at their highest bit, 
         * while the rest numbers of part two are exactly symmetric of part one.
         */
         List<Integer> rs = new ArrayList<Integer>();
         rs.add(0);
         for (int i = 0; i < n; i++) {
             for (int k = rs.size() - 1; k >= 0; k--) {
                 rs.add(rs.get(k) | 1 << i);
             }
         }
         return rs;
    }
}