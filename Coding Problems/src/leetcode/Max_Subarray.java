package leetcode;

public class Max_Subarray {
	//https://leetcode.com/problems/maximum-subarray/
    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int curMax = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            curMax += nums[i];
            max = Math.max(max, curMax);
            curMax = Math.max(curMax, 0);
        }
        return max;
    }
    
    public static void main(String[] args){
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(maxSubArray(nums));
    }
}
