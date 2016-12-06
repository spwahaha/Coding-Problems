package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations {
	//https://leetcode.com/problems/permutations/
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>(Arrays.asList(nums[0])));
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> newRes = new ArrayList<>();
            for(int j = 0; j < res.size(); j++){
                List<Integer> temp = res.get(j);
                for(int k = 0; k <= temp.size(); k++){
                    List<Integer> list = new ArrayList<>(temp);
                    list.add(k, nums[i]);
                    newRes.add(list);
                }
            }
            res = newRes;
        }
        return res;
    }
    
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, new HashSet<Integer>(), new ArrayList<Integer>());
        return res;
    }
    
    private static void helper(int[] nums, List<List<Integer>> res, HashSet<Integer> set, ArrayList<Integer> list){
        if(set.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            helper(nums, res, set, list);
            set.remove(nums[i]);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] arg) {
        System.out.println(permute(new int[]{1, 2, 3}));
        System.out.println(permute2(new int[]{1, 2, 3}));
    }
}
