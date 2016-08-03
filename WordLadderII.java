public class Solution {
    // The basic idea is:

    // 1). Use BFS to find the shortest distance between start and end, tracing the distance of crossing nodes from start node to end node, and store node's next level neighbors to HashMap;

    // 2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap: compare if the distance of the next level node equals the distance of the current node + 1.
    
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> rs = new ArrayList<List<String>>();         
        Map<String, List<String>> nodeNeighbors = new HashMap<String, List<String>>(); // Neighbors for every node
        Map<String, Integer> distance = new HashMap<String, Integer>(); // Distance of every node from beginWord
        List<String> solution = new ArrayList<String>();
        wordList.add(endWord);          
        bfs(beginWord, endWord, wordList, nodeNeighbors, distance);                 
        dfs(beginWord, endWord, wordList, nodeNeighbors, distance, solution, rs);   
        return rs;
    }

    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance) {
        for (String str : dict)
            nodeNeighbors.put(str, new ArrayList<String>());
            
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        boolean foundEnd = false;

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);                
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    nodeNeighbors.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) { // Check if visited
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) // Found the shortest path
                            foundEnd = true; // Does not "break" here, b/c need to find all paths
                        else
                            queue.offer(neighbor);
                    }
                }
            }
            if (foundEnd) break;
        }
    }

    // Find all next level nodes.    
    private List<String> getNeighbors(String node, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();

        for (char ch ='a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch) continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }
        }
        return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> nodeNeighbors, Map<String, Integer> distance, List<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(solution));
            solution.remove(solution.size() -1);
            return;
        }
        for (String next : nodeNeighbors.get(cur)) {            
            if (distance.get(next) == distance.get(cur) + 1) {
                dfs(next, end, dict, nodeNeighbors, distance, solution, res);
            }
        }
        solution.remove(solution.size() - 1);
    }
}
