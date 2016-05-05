// i: f[i]

// 0: 0
// 1: 1
// 2: 1 + 0 = 1
// 3: 1 + 1 = 2
// 4: 1 + 0 = 1
// 5: 1 + 1 = 2
// 6: 2 + 0 = 2
// 7: 2 + 1 = 3

public class Solution {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            // f[i] = f[i / 2] + i % 2
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }
}