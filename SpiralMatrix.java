public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new LinkedList<Integer>();
        if (matrix == null || matrix.length == 0)
            return rs;
            
        int left = 0, right = matrix[0].length - 1;
        int up = 0, down = matrix.length-1;
        
        while (left <= right && up <= down) { // check if boundaries are valid
           for (int i = left ;i <= right;i++) {
               rs.add(matrix[up][i]);
           }
           up++;
           for (int i = up; i <= down; i++) {
               rs.add(matrix[i][right]);
           }
           right--;
           
           if (left > right || up > down)  // check if boundaries are still valid
                break;
           for (int i = right; i >= left; i--) {
               rs.add(matrix[down][i]);
           }
           down--;
           for (int i = down; i >= up; i--) {
               rs.add(matrix[i][left]);
           }
           left++;
        }
        
        return rs;        

    }
}