package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	//https://leetcode.com/problems/3sum-closest/
    public static int threeSumClosest(int[] nums, int target) {
        Integer diff = Integer.MAX_VALUE;
        if(nums == null || nums.length == 0) return 0;
        if(nums.length < 4){
            int sum = 0;
            for(int num : nums) sum += num;
            return sum;
        }
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(sum - target) < diff){
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if(sum < target) j++;
                else k--;
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	int[] nums = {-1, 2, 1, -4};
    	int target = 1;
    	System.out.println(threeSumClosest(nums, target));
    }
}
