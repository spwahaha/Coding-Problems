package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {
	//https://leetcode.com/problems/permutations-ii/
	/*
	 * key point is how to avoid duplicates
	 * arrays are sorted
	 * when select the first elements from {1,1,2}
	 * we can't select the second "1"
	 * so, when i != 0 && nums[i] == nums[i - 1] && !set.contains(first "1")
	 * we need skip 
	 * 
	 */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        generate(nums, new ArrayList<Integer>(), res, new HashSet<Integer>());
        return res;
    }
    
    private static void generate(int[] nums, List<Integer> list, List<List<Integer>> res, HashSet<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(i)) continue;
            if(i != 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) continue;
            list.add(nums[i]);
            set.add(i);
            generate(nums, list, res, set);
            list.remove(list.size() - 1);
            set.remove(i);
            
        }
    }
    
    public static void main(String[] args){
    	System.out.println(permuteUnique(new int[]{1,1,2}));
    }
}
