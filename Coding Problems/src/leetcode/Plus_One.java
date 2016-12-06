package leetcode;

public class Plus_One {
	//https://leetcode.com/problems/plus-one/
    public static int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[0];
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
    
    public static void main(String[] args){
    	int[] nums = {9,9,9};
    	Utilis.printArray((plusOne(nums)));
    }
}
