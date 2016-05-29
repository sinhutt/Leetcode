public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int count = 1, last = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) 
                count++;
            else
                count = 1;
            if (count <= 2) {
                nums[last] = nums[i];
                last++;
            }
        }
        return last;
    }
}
