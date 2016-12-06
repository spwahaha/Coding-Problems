package fb;

public class DivideTwoIntegers {
	//https://leetcode.com/problems/divide-two-integers/
    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        long dvd = dividend;
        long dvs = divisor;
        dvd = Math.abs(dvd);
        dvs = Math.abs(dvs);
        int cnt = 0;
        while(dvd >= dvs){
            int times = 1;
            long temp = dvs;
            while(dvd / 2 >= temp){
                times += times;
                temp += temp;
            }
            dvd -= temp;
            cnt += times;
        }
        return sign * cnt;
    }
    
    public static int divide2(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        int dvd = dividend > 0 ? -dividend : dividend;
        int dvs = divisor > 0 ? -divisor : divisor;
        int cnt = 0;
        while(dvd <= dvs){
            int times = 1;
            int temp = dvs;
            while(dvd / 2 <= temp){
                times += times;
                temp += temp;
            }
            dvd -= temp;
            cnt += times;
        }
        return sign * cnt;
    }
    
    
    public static void main(String[] args){
    	System.out.println(divide2(-2147483648, -2147483648));
    }
}
