public class Solution {
    // solution 1: use idea from bubble sort
    // public int findKthLargest(int[] nums, int k) {
        // for (int i = 0; i < k; i++) {
        //     for (int j = 0; j < nums.length-1-i; j++) {
        //         if (nums[j] > nums[j+1]) {
        //             int tmp = nums[j];
        //             nums[j] = nums[j+1];
        //             nums[j+1] = tmp;
        //         }
        //     }
        // }
        // return nums[nums.length - k];
    // }
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }
    
    private int helper(int[] nums, int begin, int end, int k) {
        if (begin == end) return nums[begin];
        int pivot = partition(nums, begin, end);
        if (end - pivot == k - 1)
            return nums[pivot];
        else if (end - pivot > k - 1) 
            return helper(nums, pivot + 1, end, k);
        else
            return helper(nums, begin, pivot - 1, k - (end-pivot+1));
    }
    
    private int partition(int[] nums, int begin, int end) {
        int i = begin, j = end, pivot = nums[end];
        while (true) {
            while (nums[i] <= pivot && i < j) i++;
            while (nums[j] >= pivot && i < j) j--;
            if (i < j) swap(nums, i, j);
            else break;
        }
        swap(nums, i, end);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}