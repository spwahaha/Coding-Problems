package fb;

import java.util.Arrays;

public class CombinationSumIV {
	//https://leetcode.com/problems/combination-sum-iv/
    public static int combinationSum4(int[] nums, int target) {
        if(target == 0) return 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i]){
                sum += combinationSum4(nums, target - nums[i]);
            }
        }
        return sum;
    }
    
    
    public static int combinationSum42(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(dp, nums, target);
    }
    
    private static int helper(int[] dp, int[] nums, int target){
        if(dp[target] != -1) return dp[target];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i]){
                sum += helper(dp, nums, target - nums[i]);
            }
        }
        dp[target] = sum;
        return sum;
    }
    
    public static int combinationSum43(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if(i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args){
    	System.out.println(combinationSum4(new int[]{1,2,3}, 4));
    	System.out.println(combinationSum42(new int[]{1,2,3}, 4));
    	System.out.println(combinationSum43(new int[]{1,2,3}, 4));
    }
}
