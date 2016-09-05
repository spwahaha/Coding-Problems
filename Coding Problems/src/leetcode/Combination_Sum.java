package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
	//https://leetcode.com/problems/combination-sum/
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        solve(candidates, target, 0, list, res);
        return res;
    }
    
    private static void solve(int[] nums, int target, int level, List<Integer> list, List<List<Integer>> res){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = level; i < nums.length; i++){
            list.add(nums[i]);
            solve(nums, target - nums[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args){
    	int[] nums = {2, 3, 6, 7};
    	int target = 7;
    	System.out.println(combinationSum(nums, target));
    }
}
