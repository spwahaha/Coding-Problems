package fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import leetcode.Utilis;

public class ExistSumInSubarray {
    
	/*
	 * All positive
	 * T: O(n), S:O(1)
	 */
	public static boolean existInArray(int[] nums, int target) {
    	int l = 0;
    	int r = 0;
    	int sum = 0;
    	while(r < nums.length){
    		while(sum < target && r < nums.length){
    			sum += nums[r++];
    		}
    		while(sum >= target && l < nums.length){
    			if(sum == target && l < r) return true;
    			sum -= nums[l++];
    		}
    	}
    	return false;
    }
	
	/*
	 * contains both positive and negative
	 */
	public static boolean existInArray2(int[] nums, int target){
		if(nums == null || nums.length == 0) return false;
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		set.add(0);
		for(int num : nums){
			sum += num;
			if(set.contains(sum - target)) return true;
			set.add(sum);
		}
		return false;
	}
	
	/*
	 * Given an integer matrix, find a submatrix where the sum of numbers is zero. 
	 * Your code should return the coordinate of the left-up and right-down number.
	 * 
	 * [
  		[1 ,5 ,7],
  		[3 ,7 ,-8],
  		[4 ,-8 ,9],
		]
		return [(1,1), (2,2)]
	 */
    public static int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[2][2];
        for(int i = 0; i < matrix.length; i++){
            int[] sum = new int[n];
            for(int j = i; j < matrix.length; j++){
                for(int k = 0; k < n; k++){
                    sum[k] += matrix[j][k];
                }
                int[] subRes = subarraySum(sum, 0);
                if(subRes != null){
                    res[0][0] = i;
                    res[0][1] = subRes[0];
                    res[1][0] = j;
                    res[1][1] = subRes[1];
                    return res;
                }
            }
        }
        return res;
    }
    
    /*
     * return start and end index that sum from nums[start] to nums[end] equals to target
     * support positive and negative
     */
    private static int[] subarraySum(int[] nums, int target) {
		if(nums == null || nums.length == 0) return null;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0, -1); // the sum from index 0 to index i, inclusive
		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			if(map.containsKey(sum - target)){
				return new int[]{map.get(sum - target) + 1, i};
			}
			map.put(sum, i);
		}
		return null;
    }
    
    public static void main(String[] arg) {
        System.out.println(existInArray(new int[]{1, 2, 3}, 0));
        System.out.println(existInArray2(new int[]{1, 2, 3}, 0));
        System.out.println(existInArray2(new int[]{1, 2}, 3));
        Utilis.printArray((subarraySum(new int[]{1, 2, -3, 7, -2}, 4)));
        Utilis.printArray((subarraySum(new int[]{7, -1, 1}, 0)));
        int[][] matrix = {{1, 5, 7}, {3, 7, -8}, {4, -8, 9}};
        Utilis.printArray(submatrixSum(matrix));        
        Utilis.printArray(submatrixSum(new int[][]{{1,1,1,1,1,1,1,1,1,1,1,-10,1,1,1,1,1,1,1,1,1,1,1}}));
        
    }
	

}
