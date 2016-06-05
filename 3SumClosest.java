public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * Use 3 pointers to point current element, next element and the last element
         * If the sum is less than target, it means we have to add a larger element so next element move to the next. 
         * If the sum is greater, it means we have to add a smaller element so last element move to the second last element. 
         * Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far, then replace result with it, otherwise keep iterating.
         */ 
        int rs = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(rs - target)) {
                    rs = sum;
                }
            }
        }
        return rs;
    }
}