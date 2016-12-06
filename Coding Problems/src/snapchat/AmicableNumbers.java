package snapchat;

import java.util.*;

public class AmicableNumbers {
	static List<List<Integer>> findAmicableNumbers(int n){
		List<List<Integer>> res = new ArrayList<>();
		int[] nums = new int[n + 1];
		for(int i = 1; i <= n / 2; i++){
			for(int j = i; j <= n; j += i){
				nums[j] += i;
			}
		}
		
		for(int i = 2; i <= n; i++){
			int num = nums[i];
			if(num <= n && i == nums[num]){
				res.add(Arrays.asList(i, num));
			}
		}
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(findAmicableNumbers(290));
	}
}
