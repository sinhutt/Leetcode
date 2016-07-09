/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        char[] tmp = new char[4];
        while (n > 0) {
            int count = Math.min(n, read4(tmp));
            for (int i = 0; i < count; i++) {
                buf[index] = tmp[i];
                index++;
            }
            if (count < 4) return index;
            n = n - 4;
        }
        return index;
    }
}