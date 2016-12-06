package microsoft;

public class WaterandJug {

	//https://leetcode.com/problems/water-and-jug-problem/
    //https://discuss.leetcode.com/topic/49238/math-solution-java-solution
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == z || y == z || x + y == z) return true;
        return z % gcd(x,y) == 0;
    }
    
    private int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x % y);
    }
}
