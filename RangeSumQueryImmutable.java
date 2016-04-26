public class NumArray {

    private int[] array;

    public NumArray(int[] nums) {
        array = nums;
        for (int i = 1; i < nums.length; i++) {
            array[i] = array[i-1] + nums[i];
        }       
    }

    public int sumRange(int i, int j) {
        if (i == 0) 
            return array[j];
        return array[j] - array[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);