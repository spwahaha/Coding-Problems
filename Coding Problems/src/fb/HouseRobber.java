package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobber {
	//https://leetcode.com/problems/house-robber/
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] f = new int[nums.length];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[nums.length - 1];
    }
    
    public static int rob2(int[] nums){
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int step2 = nums[0];
        int step1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
        	int cur = Math.max(step1, step2 + nums[i]);
        	step2 = step1;
        	step1 = cur;
        }
        return step1;
    }
    
    public static List<Integer> rob3(int[] nums){
    	if(nums == null || nums.length == 0) return null;
    	if(nums.length == 1) return new ArrayList<Integer>(Arrays.asList(nums[0]));
    	List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(0));
    	List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(nums[1] > nums[0] ? 1 : 0));
        int step2 = nums[0];
        int step1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
        	int curVal = 0;
        	List<Integer> list = null;
        	if(step1 > step2 + nums[i]){
        		curVal = step1;
        		list = new ArrayList<>(list1);
        		list.add(i);
        	}else{
        		curVal = step2;
        		list = new ArrayList<>(list2);
        		list.add(i);
        	}
        	step2 = step1;
        	step1 = curVal;
        	list2 = list1;
        	list1 = list;
        }
        return list1;
    }
    
    public static void main(String[] args){
    	System.out.println(rob(new int[]{1,2,3,4,5}));
    	System.out.println(rob2(new int[]{1,2,3,4,5}));
    	System.out.println(rob3(new int[]{1,2,3,4,5}));
    }
    
}
