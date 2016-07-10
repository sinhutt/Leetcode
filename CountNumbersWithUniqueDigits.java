public class Solution {
    // Backtracking solution
//     public int countNumbersWithUniqueDigits(int n) {
//         if (n > 10) 
// 			return countNumbersWithUniqueDigits(10);
// 		int count = 1; // x == 0
// 		long max = (long) Math.pow(10, n);
// 		boolean[] used = new boolean[10];

// 		for (int i = 1; i < 10; i++) {
// 			used[i] = true;
// 			count += search(i, max, used);
// 			used[i] = false;
// 		}
// 		return count;
// 	}

// 	private static int search(long prev, long max, boolean[] used) {
// 		int count = 0;
// 		if (prev < max) count += 1;
// 	    else return count;

// 		for (int i = 0; i < 10; i++) {
// 			if (!used[i]) {
// 				used[i] = true;
// 				long cur = 10 * prev + i;
// 				count += search(cur, max, used);
// 				used[i] = false;
// 			}
// 		}
// 		return count;
// 	}
	
	// DP solution
	public int countNumbersWithUniqueDigits(int n) {
	    if (n == 0) return 1;
	    int rs = 10;
	    int uniqueDigits = 9;
	    int availableDigits = 9;
	    while (n > 1 && availableDigits > 0) {
	        uniqueDigits = uniqueDigits * availableDigits;
	        rs += uniqueDigits;
	        availableDigits--;
	        n--;
	    }
	    return rs;
	}
	
}