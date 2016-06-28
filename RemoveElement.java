public class Solution {
    public int removeElement(int[] nums, int val) {
        // int m = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != val) {
        //         nums[m]= nums[i];
        //         m++;
        //     }
        // }
        // return m;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                nums[r] = val;
                r--;
            } else {
                l++;
            }
        }
        return l;
    }
}