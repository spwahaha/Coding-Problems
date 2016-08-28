package leetcode;

public class Sqrt_x {
	//https://leetcode.com/problems/sqrtx/
    public static int mySqrt(int x) {
        if(x <= 0) return 0;
        int l = 1;
        int r = x;
        while(l <= r){
            long mid = l + (r - l) / 2;
            long square = mid * mid;
            if(mid * mid <= x && x < (mid + 1) * (mid + 1)) return (int)mid;
            else if(square < x) l = (int)mid + 1;
            else r = (int)mid - 1;
        }
        return -1;
    }
    
    public static void main(String[] args){
    	System.out.println(mySqrt(0));
    	System.out.println(mySqrt(4));
    	System.out.println(mySqrt(16));
    	System.out.println(mySqrt(36));
    	System.out.println(mySqrt(2));
    }
}
