package google;
import java.util.*;

public class LineReflection {
	//https://leetcode.com/problems/line-reflection/
    public static boolean isReflected(int[][] points) {
        if(points == null || points.length == 0) return false;
        Set<String> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int[] point : points){
            int x = point[0];
            int y = point[1];
            max = Math.max(max, x);
            min = Math.min(min, x);
            set.add(x + "|" + y);
        }
        
        long sum = max + min;
        for(int[] point : points){
            String p = (sum - point[0]) + "|" + point[1];
            if(!set.contains(p)) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	int[][] points = {{1, 1}, {-1, 1}};
    	System.out.println(isReflected(points));
    }
}
