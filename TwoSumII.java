public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];
        if (numbers == null || numbers.length < 2) return rs;
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                rs[0] = l + 1;
                rs[1] = r + 1;
                break;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return rs;
    }
}