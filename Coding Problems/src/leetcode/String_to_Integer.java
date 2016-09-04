package leetcode;

public class String_to_Integer {
	//https://leetcode.com/problems/string-to-integer-atoi/
    public static int myAtoi(String str) {
        int i = 0, sign = 1;
        long res = 0;
        // leading white space
        while(i < str.length() && str.charAt(i) == ' ') i++;
        
        // sign
        if(i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = str.charAt(i++) == '+' ? 1 : -1;
        
        while(i < str.length()){
            int digit = str.charAt(i) - '0';
            if(digit < 0 || digit > 9) break;
            res = res * 10 + digit;
            //overflow
            if(sign * res > Integer.MAX_VALUE || sign * res < Integer.MIN_VALUE)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign * res);
    }
    
    public static void main(String[] args){
    	System.out.println(myAtoi(" "));
    	System.out.println(myAtoi("1234"));
    	System.out.println(myAtoi("3000000000001"));
    	System.out.println(myAtoi("-3000000000001"));
    	System.out.println(myAtoi("-321"));
    }
}
