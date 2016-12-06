package leetcode;

public class PartitionEqualsSubsetSum {
    public static boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if((sum & 1) == 1) return false;
        int target = sum / 2;
        boolean[] f = new boolean[target + 1];
        f[0] = true;
        return helper(nums, f, target, 0);
    }
    
    public static boolean helper(int[] nums, boolean[] dp, int target, int start){
    	if(target < 0) return false;
    	if(dp[target]) return true;
    	boolean res = false;
    	for(int i = start; i < nums.length; i++){
    		if(helper(nums, dp, target - nums[i], i + 1)){
    			res = true;
    			break;
    		}
    	}
    	dp[target] = res;
    	return res;
    }
    
    public static void main(String[] args){
    	System.out.println(canPartition(new int[]{1, 2, 5}));
    }
    
    
}
