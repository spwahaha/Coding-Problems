package leetcode;

public class Valid_Perfect_Square {
	//https://leetcode.com/problems/valid-perfect-square/
    public static boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        if(num == 0) return true;
        int l = 1;
        int h = num;
        while(l <= h){
            long mid = l + (h - l) / 2;
            long square = mid * mid;
            if(square == num) return true;
            if(square < num) l = (int)mid + 1;
            if(square > num) h = (int)mid - 1;
        }
        return false;
    }
    
    public static void main(String[] args){
    	System.out.println(isPerfectSquare(Integer.MAX_VALUE));
    }
}
