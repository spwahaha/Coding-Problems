package leetcode;

public class Reverse_Integer {
	//https://leetcode.com/problems/reverse-integer/
    public static int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
    
    public static void main(String[] args){
    	System.out.println(reverse(-123));
    	System.out.println(reverse(123));
    	System.out.println(reverse(0));
    	System.out.println(reverse(1000000003));
    }
}
