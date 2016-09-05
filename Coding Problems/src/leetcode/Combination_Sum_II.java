package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
	//https://leetcode.com/problems/combination-sum-ii/
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        generate(nums, target, 0, list, res);
        return res;
    }
    
    private static void generate(int[] nums, int target, int level, List<Integer> list, List<List<Integer>> res){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = level; i < nums.length; i++){
            if(i != level && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            generate(nums, target - nums[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {10,1,2,7,6,1,5};
    	int target = 8;
    	System.out.println(combinationSum2(nums, target));
    }
}
