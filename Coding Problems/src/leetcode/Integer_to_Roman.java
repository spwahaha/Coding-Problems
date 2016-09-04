package leetcode;

public class Integer_to_Roman {
	//https://leetcode.com/problems/integer-to-roman/
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] syms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num -= values[i];
                sb.append(syms[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(intToRoman(3999));
    	System.out.println(intToRoman(1));
    	System.out.println(intToRoman(399));
    	System.out.println(intToRoman(100));
    }
}
