package leetcode;

public class Palindrome_Number {
	//https://leetcode.com/problems/palindrome-number/
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        if(x % 10 == 0) return false;
        int y = 0;
        while(x > y){
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y == x || y / 10 == x;
    }
    
    public static void main(String[] args){
    	System.out.println(isPalindrome(0));
    	System.out.println(isPalindrome(-1));
    	System.out.println(isPalindrome(1000));
    	System.out.println(isPalindrome(12345));
    	System.out.println(isPalindrome(123321));
    	System.out.println(isPalindrome(1234321));
    	System.out.println(isPalindrome(-123321));
    }
}
