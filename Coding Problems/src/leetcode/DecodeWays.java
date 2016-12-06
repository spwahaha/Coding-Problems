package leetcode;

public class DecodeWays {
	//https://leetcode.com/problems/decode-ways/
	/*
	 * from end to start
	 * f(n) = f(n + 1) if charAt(n) is not in(1~9)
	 * f(n) = f(n + 1) if charAt(n) is in (1~9) but charAt(n) + charAt(n + 1) is not in (1~26)
	 * f(n) = f(n + 1) + f(n + 2) if  charAt(n) + charAt(n + 1) is in (1~26)
	 * T: O(n) S: O(n)
	 */
	
    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int[] f = new int[n + 1];
        f[n] = 1;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            int cur = c - '0';
            if(i == s.length() - 1){
                if(cur >= 1 && cur <= 9) f[i] = 1;
            }else{
                int two = (c - '0') * 10 + s.charAt(i + 1) - '0';
                if(cur >= 1 && cur <= 9){
                    f[i] += f[i + 1];
                }
                if(two >= 10 && two <= 26){
                    f[i] += f[i + 2];
                }
            }
        }
        return f[0];
    }
    
    public static int numDecodings2(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        int next2 = 1;
        int next1 = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            int cur = c - '0';
            if(i == s.length() - 1){
                if(cur >= 1 && cur <= 9) next1 = 1;
            }else{
                int two = (c - '0') * 10 + s.charAt(i + 1) - '0';
                int res = 0;
                if(cur >= 1 && cur <= 9){
                    res += next1;
                }
                if(two >= 10 && two <= 26){
                    res += next2;
                }
                next2 = next1;
                next1 = res;
            }
        }
        return next1;
    }
    
    public static void main(String[] arg) {
        DecodeWays a = new DecodeWays();
        System.out.println(numDecodings("1231"));
        System.out.println(numDecodings2("1231"));
        System.out.println();

        System.out.println(numDecodings("1231112432"));
        System.out.println(numDecodings2("1231112432"));
        System.out.println();

        System.out.println(numDecodings("1291112432"));
        System.out.println(numDecodings2("1291112432"));
        System.out.println();
    }
    
    
}
