package fb;

public class PlusOne {
	//https://leetcode.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[0];
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i] += 1;
                return digits;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
