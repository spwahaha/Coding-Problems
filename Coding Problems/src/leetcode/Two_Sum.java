package leetcode;

import java.util.HashMap;

public class Two_Sum {
	// https://leetcode.com/problems/two-sum/
    public static int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(target - nums[i])){
                map.put(nums[i], i);    
            }else{
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	int[] nums = {2, 7, 11, 15};
    	int target = 9;
    	int[] res = twoSum(nums, target);
    	for(int num : res){
    		System.out.print(num + ",");
    	}
    }
}
