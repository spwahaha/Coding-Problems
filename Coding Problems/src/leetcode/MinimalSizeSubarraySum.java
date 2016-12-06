package leetcode;

public class MinimalSizeSubarraySum {
	//https://leetcode.com/problems/minimum-size-subarray-sum/
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while(r < nums.length){
            while(sum < s && r < nums.length){
                sum += nums[r++];
            }
            while(sum >= s && l < nums.length){
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static void main(String[] args){
    	System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
