package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {
	//https://leetcode.com/problems/permutations/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        generate(nums, list, res, new HashSet<Integer>());
        return res;
    }
    
    private static void generate(int[] nums, List<Integer> list, List<List<Integer>> res, HashSet<Integer> set){
        if(set.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(i)){
                set.add(i);
                list.add(nums[i]);
                generate(nums, list, res, set);
                list.remove(list.size() - 1);
                set.remove(i);
            }
        }
    }
    
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        res.add(list);
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> newRes = new ArrayList<List<Integer>>();
            for(int j = 0; j < res.size(); j++){
                List<Integer> temp = res.get(j);
                for(int k = 0; k <= temp.size(); k++){
                    List<Integer> newList = new ArrayList<Integer>(temp);
                    newList.add(k, nums[i]);
                    newRes.add(newList);
                }
            }
            res = newRes;
        }
        return res;
    }
    
    
    public static void main(String[] args){
    	int[] nums = {1,2,3};
    	System.out.println(permute(nums));
    	System.out.println(permute2(nums));
    }
}
