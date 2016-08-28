package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class MaxSum_of_Rectangle_No_Larger_Than_K {
	//https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0) return 0;
        int res = Integer.MIN_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int l = 0; l < col; l++){
            int[] sums = new int[row];
            for(int r = l; r < col; r++){
                for(int i = 0; i < row; i++){
                    sums[i] += matrix[i][r];
                }
                TreeSet<Integer> treeSet = new TreeSet<Integer>();
                treeSet.add(0);
                int curSum = 0;
                for(int sum : sums){
                    curSum += sum;
                    Integer preSum = treeSet.ceiling(curSum - k);
                    if(preSum != null) res = Math.max(res, curSum - preSum);
                    treeSet.add(curSum);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	int[][] nums = {{1, 0, 1}, {0, -2, 3}};
    	int k = 2;
    	System.out.println(maxSumSubmatrix(nums, k));
    }
}
