public class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
    
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> rs = new ArrayList<String>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, rs);
            }
        }
        return rs;
    }
    
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> rs) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) { // found one
            rs.add(p.word);
            p.word = null; // de-duplicate
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, rs); 
        if (j > 0) dfs(board, i, j - 1, p, rs);
        if (i < board.length - 1) dfs(board, i + 1, j, p, rs); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, rs); 
        board[i][j] = c;
    }
}




