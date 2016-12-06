package google;

public class UTF8Validation {
	//https://leetcode.com/problems/utf-8-validation/
    public boolean validUtf8(int[] data) {
        int count = 0;
        for(int val : data){
            if(count == 0){
                // System.out.println((val >> 4) + ",,");
                if((val >> 7) == 0) count = 0;
                else if((val >> 5) == 6) count = 1;
                else if((val >> 4) == 14) count = 2;
                else if((val >> 3) == 30) count = 3;
                else return false;
            }else{
                if((val >> 6) != 2) return false;
                else count--;
            }
            // System.out.println(count);
        }
        return count == 0;
    }
}
