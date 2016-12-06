package fb;

public class MaximumSubarray {
	//https://leetcode.com/problems/maximum-subarray/
    public static int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            curMax = Math.max(curMax, 0);
            curMax = curMax + nums[i];
            max = Math.max(max, curMax);
        }
        return max;
    }
    
    public static void main(String[] arg) {
        System.out.println(maxSubArray(new int[]{1, 2}));
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
