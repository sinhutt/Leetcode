public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // solution based on 3Sum
        ArrayList<List<Integer>> rs = new ArrayList<>();
        if (nums.length < 4)return rs;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue; // avoids duplicates
            for (int j = i+1; j < nums.length-2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue; // avoids duplicates
                int low = j+1, high = nums.length-1;
                while (low < high) {
                    int sum = nums[i]+nums[j]+nums[low]+nums[high];
                    if (sum == target) {
                        rs.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low+1]) low++;
                        while (low < high && nums[high] == nums[high-1]) high--;
                        low++;
                        high--;
                    }
                    else if (sum < target) low++;
                    else high--;
                }
            }
        }
        return rs;
    }
}