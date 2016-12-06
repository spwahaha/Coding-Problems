package fb;
import java.util.*;

import leetcode.Utilis;

public class ReservoirSampling {
	// k/m * (m / m + 1) * ((m + 1) / (m + 2)) * .. *((n - 1) / n)
	public static int[] selectKItems(int[] nums, int k){
		if(nums == null || nums.length < k) return new int[0];
		Random random = new Random();
		int[] res = new int[k];
		int index = 0;
		for(int i = 0; i < nums.length; i++){
			if(i < k){
				res[index++] = nums[i];
			}else{
				index++;
				int temp = random.nextInt(index);
				if(temp < k){
					res[temp] = nums[i];
				}
			}
		}
		
		return res;
	}
	
	public static int[] selectKItems2D(int[][] nums, int k){
		if(nums == null || nums.length == 0) return new int[0];
		int m = nums.length;
		int n = nums[0].length;
		if(m * n < k) return new int[0];
		Random random = new Random();
		int[] res = new int[k];
		int index = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(index < k){
					res[index++] = nums[i][j];
				}else{
					index++;
					int temp = random.nextInt(index);
					if(temp < k){
						res[temp] = nums[i][j];
					}
				}
			}
		}
		
		return res;
	}
	
	
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7};
		Utilis.printArray(selectKItems(nums, 3));
		int[][] matrix = {{1,2,3,4,5},
						  {6,7,8,9,10},
						  {11, 12, 13, 14, 15}};
		Utilis.printArray(selectKItems2D(matrix, 5));

	}
}
