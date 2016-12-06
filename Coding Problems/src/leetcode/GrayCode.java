package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {
	//https://leetcode.com/problems/gray-code/
    public static List<Integer> grayCode(int n) {
        if(n < 0) return null;
        if(n == 0){
            return new ArrayList<>(Arrays.asList(0));
        }
        List<Integer> before = grayCode(n - 1);
        int add = (int)Math.pow(2, n - 1);
        for(int i = before.size() - 1; i >= 0; i--){
            before.add(add + before.get(i));
        }
        return before;
    }
    
    public static List<Integer> grayCode2(int n){
    	if(n < 0) return null;
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(0);
    	for(int i = 1; i <= n; i++){
    		int add = (int)Math.pow(2, i - 1);
    		for(int j = list.size() - 1; j >= 0; j--){
    			list.add(add + list.get(j));
    		}
    	}
    	return list;
    }
    
    public static void main(String[] args){
    	System.out.println(grayCode(2));
    	System.out.println(grayCode2(5));
    }
}
