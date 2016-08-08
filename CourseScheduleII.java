public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return null;
		int[] rs = new int[numCourses];
		int index = 0;
		if (prerequisites.length == 0 || prerequisites[0].length == 0) {
			while (index < numCourses) {
				rs[index] = index;
				index++;
			}
			return rs;
		}
        
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) 
            graph[i] = new ArrayList<Integer>();
        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        index = 0;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (queue.size() != 0) {
            int course = queue.poll();
            count++;
            rs[index] = course;
            index++;
            for (int i = 0; i < graph[course].size(); i++) {
                int pre = (int)graph[course].get(i);
                degree[pre]--;
                if (degree[pre] == 0) {
                    queue.add(pre);
                }
            }
        }
        if (count == numCourses) return rs;
        else return new int[0];
    }
}