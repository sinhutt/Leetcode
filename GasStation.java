public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * The idea is simple.
         * Whenever remainder is negative, reset it and let the car start from next point.
         * In the mean time, add up all of the left gas to total. 
         * If total is negative finally, return -1 since it's impossible to finish.
         * If it's non-negative, return the last point saved in result;
         */ 
        int total = 0;
        int remainder = 0;
        int result = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            remainder += gas[i] - cost[i];
            if (remainder < 0) {
                remainder = 0;
                result = i + 1;
            }
        }
        return total < 0 ? -1 : result;
    }
}