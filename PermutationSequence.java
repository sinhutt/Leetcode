public class Solution {
    public String getPermutation(int n, int k) {
        // analysis see:
        // https://leetcode.com/discuss/42700/explain-like-im-five-java-solution-in-o-n
        List<Integer> numbers = new ArrayList<Integer>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        
        // create an array of factorial lookup
        // factorial[] = {1, 1, 2, 6, 24, ... , n!}
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum = sum * i;
            factorial[i] = sum;
        }
        
        // create a list of numbers to get indices
        // numbers = {1, 2, 3, 4, ...}
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
    
        k--;
        
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k = k - index * factorial[n-i];
        }
    
        return String.valueOf(sb);
    }
}

