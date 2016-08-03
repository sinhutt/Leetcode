public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // solution using PriorityQueue: O(klogk)
        List<int[]> rs = new ArrayList<int[]>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return rs;
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>() {
	        @Override
	        public int compare(int[] o1, int[] o2) {
		        return o1[0] + o1[1] - o2[0] - o2[1];
	        }
        });
        for (int i = 0; i < nums1.length && i < k; i++) {
            heap.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            rs.add(new int[]{cur[0], cur[1]});
            k--;
            if (cur[2] != nums2.length - 1) 
                heap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return rs;
    }
}