public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) return a; // if there is not carry
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
}