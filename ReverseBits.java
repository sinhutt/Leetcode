public class Solution {
    // you need treat n as an unsigned value
    // public int reverseBits(int n) {
    //     int result = 0;
    //     for (int i = 0; i < 32; i++) {
    //         result += (n & 1);
    //         /* signed v.s. unsigned right shift
    //          * signed right shift (i.e. >>) fills by 0 or 1 depending on if positive or negative
    //          * unsigned right shift (i.e. >>>) always fills by 0
    //          */
    //         n = n >>> 1; 
    //         if (i != 31) {
    //             result = result << 1;
    //         }
    //     }
    //     return result;
    // }
    
    // optimized
    private Map<Byte, Integer> cache = new HashMap<Byte, Integer>();
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte) (n & 0xff);
            n = n >>> 8;
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += reverseByte(bytes[i]);
            if (i != 3) {
                result = result << 8;
            }
        }
        return result;
    }
    private int reverseByte(byte b) {
        Integer val = cache.get(b);
        if (val != null) return val;
        val = 0;
        for (int i = 0; i < 8; i++) {
            val += ((b >>> i) & 1);
            // b = b >>> 1;  // note: lossy conversion from int to byte, as >>> operates on int
            if (i != 7) {
                val = val << 1;
            }
        }
        cache.put(b, val);
        return val;
    }
}