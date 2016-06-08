public class Solution {
    public void nextPermutation(int[] nums) {
        /**
         * search from the end, until we find the first two consecutive elements, such that first < second
         * then search again from the end, until we find number at index x such that > first
         * swap first and this number at index x
         * then reverse all elements after second (inclusive)
         * 
         * e.g. 6，3，4，9，8，7，1, first ＝ 4，second = 9 
         * the first number > first is 7, so switch 4 and 7, we get: 6，3，7，9，8，4，1
         * then we reverse all elements after second = 9, we get: 6，3，7，1，4，8，9
         */ 
         
        // find two adjacent elements, n[i-1] < n[i]
        int i = nums.length - 1;
        while (i > 0) {
            if (nums[i] > nums[i-1]) break;
            i--;
        }
        
        if (i != 0) {
            // swap (i-1, x), where x is index of the smallest number in [i, end)
            int x = nums.length - 1;
            while (x > i - 1) {
                if (nums[x] > nums[i-1]) break;
                x--;
            }
            swap(nums, i-1, x);
        }
        // reverse the elements from i till the end
        reverse(nums, i, nums.length - 1);
    }
    
    // swap a[i] and a[j]
    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    // reverse a[i, j]
    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
}
