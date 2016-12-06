package fb;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
	//https://leetcode.com/problems/combination-sum/
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, target, res, list);
        return res;
    }
    
    private void helper(int[] nums, int level, int target, List<List<Integer>> res, List<Integer> list){
        if(target <= 0){
            if(target < 0) return;
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = level; i < nums.length; i++){
            list.add(nums[i]);
            helper(nums, i, target - nums[i], res, list);
            list.remove(list.size() - 1);
        }
    }
    
    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<>();
    	List<Integer> list = new ArrayList<>();
    	Stack<Integer> sumStack = new Stack<Integer>();
    	Stack<Integer> indexStack = new Stack<Integer>();
    	Stack<List<Integer>> pathStack = new Stack<List<Integer>>();
    	sumStack.push(0);
    	indexStack.push(0);
    	pathStack.push(new ArrayList<Integer>());
    	while(!sumStack.isEmpty()){
    		int val = sumStack.pop();
    		int index = indexStack.pop();
    		List<Integer> path = pathStack.pop();
    		if(val == target){
    			res.add(new ArrayList<Integer>(path));
    		}else if(val > target){
    			continue;
    		}else{
    			for(int i = index; i < nums.length; i++){
    				List<Integer> temp = new ArrayList<Integer>(path);
    				temp.add(nums[i]);
    				pathStack.push(temp);
    				sumStack.push(val + nums[i]);
    				indexStack.push(i);
    			}
    		}
    	}
    	return res;
   	}

    
    public static void main(String[] args){
    	System.out.println(combinationSum2(new int[]{2, 3, 6, 7}, 7));
    }
}
