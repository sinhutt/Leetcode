/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2; 
            // int mid = (start + end) / 2;
            // the line above is wrong, b/c test cases include the MAX_Integer 2147483647, 
            // which means 2147483647 + 1 will turn out to be a negative value
            int rs = guess(mid);
            if (rs == 0) return mid;
            else if (rs == -1) end = mid - 1;
            else if (rs == 1) start = mid + 1;
        }
        return start;
    }
}