package leetcode;

public class Multiply_String {
	//https://leetcode.com/problems/multiply-strings/
    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1 == "" || num2 == "") return "";
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            int int1 = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j--){
                int int2 = num2.charAt(j) - '0';
                res[i + j + 1] += int1 * int2;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < res.length && res[index] == 0) index++;
        while(index < res.length){
            sb.append("" + res[index++]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(multiply("12","11"));
    }
}
