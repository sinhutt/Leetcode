public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // recursive
        List<Integer> rs = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' ||
                input.charAt(i) == '-' ||
                input.charAt(i) == '*') {
                    String before = input.substring(0, i);
                    String after = input.substring(i + 1);
                    List<Integer> beforeRS = diffWaysToCompute(before);
                    List<Integer> afterRS = diffWaysToCompute(after);
                    for (Integer r1 : beforeRS) {
                        for (Integer r2 : afterRS) {
                            int c = 0;
                            switch (input.charAt(i)) {
                                case '+': 
                                    c = r1 + r2;
                                    break;
                                case '-':
                                    c = r1 - r2;
                                    break;
                                case '*':
                                    c = r1 * r2;
                                    break;
                            }
                            rs.add(c);
                        }
                    }
                }
        }
        if (rs.size() == 0) 
            rs.add(Integer.valueOf(input));
        return rs;
    }
}