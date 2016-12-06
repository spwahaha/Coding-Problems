package leetcode;
import java.util.*;

public class CombinationSumIII {
	//https://leetcode.com/problems/combination-sum-iii/
    public static List<List<Integer>> combinationSum3(int k, int n) {
        // from 1 ~ 9, k numbers sum is n
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, 1, k, n);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, List<Integer> list, int start, int k, int n){
        if(n < 0) return;
        if(list.size() == k){
            if(n == 0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        
        for(int i = start; i <= 9; i++){
            list.add(i);
            helper(res, list, i + 1, k, n - i);
            list.remove(list.size() - 1);
        }
    }
    
    public static void main(String[] args){
    	System.out.println(combinationSum3(3, 7));
    }
    
}
