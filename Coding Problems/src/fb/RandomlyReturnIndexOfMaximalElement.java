package fb;

import java.util.*;

public class RandomlyReturnIndexOfMaximalElement {
	
	/*
	 * Reservoir sampling
	 */
	public static int findMax(int[] nums){
		Random rand = new Random();
		int max = Integer.MIN_VALUE;
		int res = 0;
		int cnt = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == max){
				cnt++;
				int r = rand.nextInt(cnt);
				if(r == 0) res = i;
			}else if(nums[i] > max){
				cnt = 1;
				max = nums[i];
				res = i;
			}
		}
		return res;
	}
	
	public static int findMax1(int[] nums){
		List<Integer> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == max){
				list.add(i);
			}else if(nums[i] > max){
				max = nums[i];
				list = new ArrayList<>();
				list.add(i);
			}
		}
		Random ran = new Random();
		return list.get(ran.nextInt(list.size()));
	}
	
    public static void main(String[] arg) {
        System.out.println(findMax(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax1(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax1(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax1(new int[]{1, 2, 4, 4, 2, 3, 4}));
        System.out.println(findMax1(new int[]{1, 2, 4, 4, 2, 3, 4}));
    }
}
