package fb;

import java.util.HashMap;

public class MaxPointsOnaLine {
    public int maxPoints(Point[] points) {
        int max = 0;
        for(int i = 0; i < points.length; i++){
            int curMax = 0;
            int overlap = 0;
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
            for(int j = i + 1; j < points.length; j++){
                Point p1 = points[i];
                Point p2 = points[j];
                int x = (int) (p1.x - p2.x);
                int y = (int) (p1.y - p2.y);
                if(x == 0 && y == 0){
                    overlap++;
                    continue;
                }
                int gcd = gcd(y,x);
                x /= gcd;
                y /= gcd;
                if(map.containsKey(x)){
                    int cnt = map.get(x).containsKey(y) ? map.get(x).get(y) + 1 : 1;
                    map.get(x).put(y, cnt);
                }else{
                    HashMap<Integer ,Integer> temp = new HashMap<>();
                    temp.put(y, 1);
                    map.put(x, temp);
                }
                curMax = Math.max(curMax, map.get(x).get(y));
            }
            max = Math.max(max, curMax + overlap + 1);
        }
        return max;
    }
    
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
