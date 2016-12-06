package google;

import leetcode.Utilis;

public class SortTransformedArray {
	//https://leetcode.com/problems/sort-transformed-array/
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;
        int p = a > 0 ? nums.length - 1 : 0;
        while(p >= 0 && p < nums.length){
            if(a > 0){
                if(calculate(nums[l], a, b, c) > calculate(nums[r], a, b, c)){
                    res[p--] = calculate(nums[l++], a, b, c);
                }else{
                    res[p--] = calculate(nums[r--], a, b, c);
                }
            }else{
                if(calculate(nums[l], a, b, c) < calculate(nums[r], a, b, c)){
                    res[p++] = calculate(nums[l++], a, b, c);
                }else{
                    res[p++] = calculate(nums[r--], a, b, c);
                }
            }
        }
        return res;
    }
    
    private int calculate(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
    
}
