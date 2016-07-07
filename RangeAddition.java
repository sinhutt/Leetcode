public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        /**
         * Just store every start index for each value and at end index plus one minus it
         * for example it will look like:
         * [1 , 3 , 2] , [2, 3, 3] (length = 5)
         * res[ 0, 2, ,0, 0 -2 ]
         * res[ 0 ,2, 3, 0, -5]
         * sum 0, 2, 5, 5, 0
         * res[0, 2, 5, 5, 0]
         */
         int[] rs = new int[length];
         for (int[] update : udpates) {
             int start = update[0];
             int end = update[1] + 1;
             int value = update[2];
             rs[start] = value;
             rs[end] = -value;
         }
         int sum = 0;
         for (int i = 0; i < length; i++) {
             sum += rs[i];
             rs[i] = sum;
         }
         return rs;
    }
}