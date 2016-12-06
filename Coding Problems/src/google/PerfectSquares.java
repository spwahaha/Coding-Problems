package google;

public class PerfectSquares {
	//https://leetcode.com/problems/perfect-squares/
    public static int numSquares(int n) {
        if(n <= 0) return 0;
        int[] f = new int[n + 1];
        for(int i = 1; i <= n; i++){
            f[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                f[i] = Math.min(f[i], f[i - j * j ] + 1);
            }
        }
        return f[n];
    }
    
    public static void main(String[] args){
    	System.out.println(numSquares(12));
    	System.out.println(numSquares(16));
    	System.out.println(numSquares(13));
    	System.out.println(numSquares(7));
    }
}
