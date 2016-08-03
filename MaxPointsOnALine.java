/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length <= 2) return points.length;
        int rs = 0;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            int sameX = 1, samePoint = 0;
            for (int j = 0; j < points.length; j++) { // we cannot start from i + 1
                if (i != j) {
                    Point p2 = points[j];
                    if (p1.x == p2.x && p1.y == p2.y) { // note: order of the two if's is important
                        samePoint++; 
                    }
                    if (p1.x == p2.x) {
                        sameX++;
                        continue;
                    }
                    double slope = (double) (p1.y - p2.y) / (double) (p1.x - p2.x);
                    if (map.containsKey(slope)) {
                        map.put(slope, map.get(slope) + 1);
                    } else {
                        map.put(slope, 2); // note the 2 here
                    }
                    rs = Math.max(rs, map.get(slope) + samePoint);
                }
            }
            rs = Math.max(rs, sameX);
        }
        return rs;
    }
}

