package fb;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumKProduct {
	
	public static long maxKProduct(Integer[] nums, int k){
		if(nums == null || nums.length < k) return 0;
		Arrays.sort(nums, new Comparator<Integer>(){
			public int compare(Integer i1, Integer i2){
				long n1 = i1;
				long n2 = i2;
				long prod = n1 * n2;
				if(prod > 0){
					return i2 - i1;
				}else if(prod == 0){
					return i1 == 0 ? 1 : -1;
				}else{
					return i1 > 0 ? 1 : -1;
				}
			}
		});
		
		long temp = 1;
		int cnt = 0;
		long max = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 0) return max;
			temp *= nums[i];
			cnt++;
			if(cnt == k){
				max = Math.max(max,  temp);
				temp /= nums[i + 1 - k];
				cnt--;
			}
		}
		return max;
	}
	
    public static void main(String[] arg) {
        System.out.println(maxKProduct(new Integer[]{-1, 2, 3, 5, -9}, 3));
    }
}
