public class Solution {
    // BFS cycle detection
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     ArrayList[] graph = new ArrayList[numCourses];
    //     int[] degree = new int[numCourses];
    //     Queue<Integer> queue = new LinkedList<Integer>();
    //     int count = 0;
    //     for (int i = 0; i < numCourses; i++) 
    //         graph[i] = new ArrayList<Integer>();
    //     for (int i = 0; i < prerequisites.length; i++) {
    //         degree[prerequisites[i][1]]++;
    //         graph[prerequisites[i][0]].add(prerequisites[i][1]);
    //     }
    //     for (int i = 0; i < degree.length; i++) {
    //         if (degree[i] == 0) {
    //             queue.add(i);
    //             count++;
    //         }
    //     }
    //     while (queue.size() != 0) {
    //         int course = queue.poll();
    //         for (int i = 0; i < graph[course].size(); i++) {
    //             int pre = (int)graph[course].get(i);
    //             degree[pre]--;
    //             if (degree[pre] == 0) {
    //                 queue.add(pre);
    //                 count++;
    //             }
    //         }
    //     }
    //     if (count == numCourses) return true;
    //     else return false;
    // }
    
    // DFS cycle detection
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) 
            graph[i] = new ArrayList<Integer>();
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) return false;
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
        if (visited[course]) return false;
        else visited[course] = true;;
        for (int i = 0; i < graph[course].size(); i++) {
            if (!dfs(graph, visited, (int)graph[course].get(i)))
                return false;
        }
        visited[course] = false;
        return true;
    }
}