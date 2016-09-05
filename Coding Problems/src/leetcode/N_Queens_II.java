package leetcode;

public class N_Queens_II {
	//https://leetcode.com/problems/n-queens-ii/
    public static int totalNQueens(int n) {
        if(n <= 0) return 0;
        return solve(new int[n], 0, n);
    }
    
    private static int solve(int[] nums, int row, int n){
        if(row >= n) return 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(valid(nums, i, row)){
                // put one at rowth row at position i
                nums[row] = i;
                sum += solve(nums, row + 1, n);
            }
        }
        return sum;
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
    	System.out.println(totalNQueens(4));
    }
    
}
