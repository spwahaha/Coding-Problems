package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	//https://leetcode.com/problems/n-queens/
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n <= 0) return res;
        List<List<Integer>> plans = new ArrayList<List<Integer>>();
        solve(new int[n], 0, n, plans);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) sb.append(".");
        for(List<Integer> plan : plans){
            List<String> list = new ArrayList<String>();
            for(int posi : plan){
                StringBuilder line = new StringBuilder(sb);
                line.replace(posi, posi + 1, "Q");
                list.add(line.toString());
            }
            res.add(list);
        }
        return res;
    }
    
    private static void solve(int[] nums, int row, int n, List<List<Integer>> plans){
        if(row >= n){
            List<Integer> list = new ArrayList<Integer>();
            for(int num : nums) list.add(num);
            plans.add(list);
            return;
        }
        for(int i = 0; i < n; i++){
            if(valid(nums, i, row)){
                // put one at rowth row at position i
                nums[row] = i;
                solve(nums, row + 1, n, plans);
            }
        }
    }
    
    private static boolean valid(int[] nums, int col, int row){
        // put one at rowth row, colth column
        for(int i = 0; i < row; i++){
            if(nums[i] == col) return false;
        }
        
        for(int i = 0; i < row; i++){
            int row1 = i;
            int row2 = row;
            int col1 = nums[i];
            int col2 = col;
            if(Math.abs(row1 - row2) == Math.abs(col1 - col2)) return false;
        }
        return true;
    }
    
    public static void main(String[] args){
    	System.out.println(solveNQueens(4));
    }
}
