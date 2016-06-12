public class Solution {
    // use two hash sets, time complexity O(n)
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     Set<Integer> set = new HashSet<Integer>();
    //     Set<Integer> intersect = new HashSet<Integer>();
    //     for (int i = 0; i < nums1.length; i++) {
    //         set.add(nums1[i]);
    //     }
    //     for (int i = 0; i < nums2.length; i++) {
    //         if (set.contains(nums2[i])) {
    //             intersect.add(nums2[i]);
    //         }
    //     }
    //     int[] result = new int[intersect.size()];
    //     int i = 0;
    //     for (Integer num : intersect) {
    //         result[i] = num;
    //         i++;
    //     }
    //     return result;
    // }
    
    // sort both arrays, use two pointers, time complexity O(nlogn)
    // public int[] intersection(int[] nums1, int[] nums2) {
    //     Set<Integer> set = new HashSet<Integer>();
    //     Arrays.sort(nums1);
    //     Arrays.sort(nums2);
    //     int i = 0;
    //     int j = 0;
    //     while (i < nums1.length && j < nums2.length) {
    //         if (nums1[i] < nums2[j]) {
    //             i++;
    //         } else if (nums1[i] > nums2[j]) {
    //             j++;
    //         } else {
    //             set.add(nums1[i]);
    //             i++;
    //             j++;
    //         }
    //     }
    //     int[] result = new int[set.size()];
    //     int k = 0;
    //     for (Integer num : set) {
    //         result[k] = num;
    //         k++;
    //     }
    //     return result;
    // }
    
    // binary search, time complexity O(nlogn)
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i] = num;
            i++;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) 
                return true;
            else if (nums[mid] > target) 
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}