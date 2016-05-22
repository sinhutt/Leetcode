// nthSuperUglyNumber(6, [2, 5, 7])

// 1. [1]				
// [2, 5, 7] --> [0, 0, 0]
// min(1*2, 1*5, 1*7) --> 2

// 2. [1, 2]			
// [2, 5, 7] --> [1, 0, 0]
// min(2*2, 1*5, 1*7) --> 4

// 3. [1, 2, 4]
// [2, 5, 7] --> [2, 0, 0]
// min(4*2, 1*5, 1*7) --> 5

// 4. [1, 2, 4, 5]
// [2, 5, 7] --> [2, 1, 0]
// min(4*2, 2*5, 1*7) --> 7

// 5. [1, 2, 4, 5, 7]
// [2, 5, 7] --> [2, 1, 1]
// min(4*2, 2*5, 2*7) --> 8

// 6. [1, 2, 4, 5, 7, 8]
// [2, 5, 7] --> [3, 1, 1]
// min(5*2, 2*5, 2*7) --> 10 <-- answer

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        int[] indexes = new int[primes.length];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                res[i] = Math.min(res[i], primes[j] * res[indexes[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (res[i] == primes[j] * res[indexes[j]]) 
                    indexes[j]++;
            }
        }
        return res[n-1];
    }
}

