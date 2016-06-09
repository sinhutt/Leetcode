public class Solution {
    public int hIndex(int[] citations) {
        int l = 0, len = citations.length, r = len - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (citations[mid] >= len - mid) 
                r = mid - 1;
            else
                l = mid + 1;
        }
        return len - l;
    }
}
