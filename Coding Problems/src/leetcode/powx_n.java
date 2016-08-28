package leetcode;

public class powx_n {
	//https://leetcode.com/problems/powx-n/
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            double temp = myPow(x, -(n / 2));
            if(n % 2 == 0) return 1 / (temp * temp);
            else return 1 / (temp * temp * x);
        }else{
            double temp = myPow(x, n / 2);
            if(n % 2 == 0) return temp * temp;
            else return temp * temp * x;
        }
    }
    
    public static void main(String[] args){
    	System.out.println(myPow(1.00000, -2147483648));
    }
}
