package fb;

public class MagicNumber {
	
	/*
	 * f(n) = f(n - 1) + f(n - 2);
	 */
    public static int fib(int n) {
    	if(n < 0) return -1;
    	if(n <= 1) return 1;
    	int[] f = new int[n + 1];
    	f[0] = 1;
    	f[1] = 1;
    	for(int i = 2; i <= n; i++){
    		f[i] = f[i - 1] + f[i - 2];
    	}
    	return f[n];
    }
    
    public static int fib2(int n) {
    	if(n < 0) return -1;
    	if(n <= 1) return 1;
    	int f2 = 1;
    	int f1 = 1;
    	for(int i = 2; i <= n; i++){
    		int cur = f1 + f2;
    		f2 = f1;
    		f1 = cur;
    	}
    	return f1;
    }
    
    public static int fib3(int n) {
    	if(n < 0) return -1;
    	if(n <= 1) return 1;
    	int[] f = new int[n + 1];
    	f[0] = 1;
    	f[1] = 1;
    	return helper(n - 1, f) + helper(n - 2, f);
    }
    
    private static int helper(int n, int[] f){
    	if(f[n] != 0) return f[n];
    	f[n] = helper(n - 1, f) + helper(n - 2, f);
    	return f[n];
    }
    
    /*
     * f(n) = f(n - 1) + 3*f(n - 3)
     */
    public static int magicNumber(int n){
    	if(n <= 0) return 1;
    	int[] f = new int[n + 1];
    	return helper2(n, f);
    }
    
    private static int helper2(int n, int[] f){
    	if(n <= 0) return 1;
    	if(f[n] != 0) return f[n];
    	f[n] = helper2(n - 1, f) + 2 * helper2(n - 3, f);
    	return f[n];
    }
    
    

    
    public static void main(String[] agr) {
        MagicNumber a = new MagicNumber();
        System.out.println(fib(5));
        System.out.println(fib2(5));
        System.out.println(fib3(5));
        System.out.println(magicNumber(5));
    }


}
