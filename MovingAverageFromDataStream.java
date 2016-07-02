public class MovingAverage {
    private double sum = 0.0;
    private int maxSize;
    private Queue<Integer> window;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new LinkedList<Integer>();
        maxSize = size;
    }
    
    public double next(int val) {
        if (window.size() == maxSize) 
            sum -= window.poll();
        sum += val;
        window.offer(val);
        return sum / window.size();
    }
}

