package leetcode;

public class Divide_Two_Integers {
	//https://leetcode.com/problems/divide-two-integers/
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 0) return Integer.MAX_VALUE;
        int cnt = 0;
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long dvd = dividend;
        long dvs = divisor;
        dvd = Math.abs(dvd);
        dvs = Math.abs(dvs);
        while(dvd >= dvs){
            long tmp = dvs;
            int times = 1;
            while(dvd - tmp - tmp >= 0){
                tmp = tmp + tmp;
                times = times + times;
            }
            dvd -= tmp;
            cnt += times;
        }
        return positive ? cnt : -cnt;
    }
    
    public static void main(String[] args){
    	System.out.println(divide(-2147483648, 1));
    	System.out.println(divide(-2147483648, -1));
    	System.out.println(divide(-2147483648, 0));
    }
}
