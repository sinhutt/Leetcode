public class Solution {
    // use sorting, O(nlog(n))
    // public int hIndex(int[] citations) {
    //     if (citations == null || citations.length == 0) return 0;
    //     Arrays.sort(citations);
    //     int n = citations.length;
    //     // we want the maximum, so start from 0
    //     for (int i = 0; i < n; i++) {
    //         // there are n - i elements(including citations[i]) on the right-hand side of citations[i], 
    //         // so there are n - i elements >= citations[i], 
    //         // if citations[i] >= n - i, there are must be n - i elements that >= n - i, so n - i is what we need
    //         if (citations[i] >= n - i) return n - i;
    //     }
    //     return 0;
    // }
    
    // use extra space, O(n)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int L = citations.length;
        // counts stores the number of papers having citation equal to its index for i = 0 to L-1
        // index L of counts stores the number of papers having citation greater than L
        int[] counts = new int[L+1];
        for (int c : citations) {
            if (c > L) counts[L]++;
            else counts[c]++;
        }
        int res = 0;
        // index i is h-index if summation of all elements from counts[i] to counts[L] >= i
        // scan from the left to find the maximum
        for (int i = L; i >= 0; i--) {
            res += counts[i];
            if (res >= i) return i;
        }
        return 0;
    }
}