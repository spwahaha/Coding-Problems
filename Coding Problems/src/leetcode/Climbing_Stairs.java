package leetcode;

public class Climbing_Stairs {
	//https://leetcode.com/problems/climbing-stairs/
    public static int climbStairs(int n) {
        if(n <= 0) return 0;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i <= n; i++){
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
    
    public static int climbStairs2(int n) {
        if(n <= 0) return 0;
        int b1 = 1;
        int b2 = 1;
        for(int i = 2; i <= n; i++){
            int now = b1 + b2;
            b1 = b2;
            b2 = now;
        }
        return b2;
    }
    
    public static void main(String[] args){
    	System.out.println(climbStairs(2));
    	System.out.println(climbStairs(3));
    	System.out.println(climbStairs(4));
    	System.out.println(climbStairs(5));
    	System.out.println(climbStairs(6));
    	System.out.println("----------------------------");
    	System.out.println(climbStairs2(2));
    	System.out.println(climbStairs2(3));
    	System.out.println(climbStairs2(4));
    	System.out.println(climbStairs2(5));
    	System.out.println(climbStairs2(6));
    }
}
