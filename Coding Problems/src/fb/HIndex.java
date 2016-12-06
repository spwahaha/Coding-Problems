package fb;

import java.util.Arrays;

public class HIndex {
	//https://leetcode.com/problems/h-index/
    public static int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int len = citations.length;
        for(int i = 0; i < len; i++){
            if(citations[i] >= len - i) return len - i;
        }
        return 0;   
    }
    
    
    public static int hIndex2(int[] citations) {
        int len = citations.length;
        if(len == 0) return 0;
        int[] array2 = new int[len + 1];
        for(int i = 0; i < len; i++){
            if(citations[i] >= len){
                array2[len] += 1;
            }else{
                array2[citations[i]] += 1;
            }
        }
        
        int sum = 0;
        for(int i = len; i >= 0; i--){
            sum += array2[i];
            if(sum >= i) return i;
        }
        return 0;
    }
    
    
    public static void main(String[] args){
    	System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    	System.out.println(hIndex2(new int[]{3, 0, 6, 1, 5}));
    }
}
