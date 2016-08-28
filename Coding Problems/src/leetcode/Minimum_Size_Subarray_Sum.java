package leetcode;

public class Minimum_Size_Subarray_Sum {
	//https://leetcode.com/problems/minimum-size-subarray-sum/
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(l < nums.length && r <= nums.length){
            if(sum < s){
                if(r == nums.length) break;
                sum += nums[r++];
            }else{
                len = Math.min(len, r - l);
                sum -= nums[l++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    
    public static int minSubArrayLen2(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(l < nums.length && r < nums.length){
            while(r < nums.length && sum < s){
                sum += nums[r++];
            }
            while(l < nums.length && sum >= s){
                len = Math.min(len, r - l);
                sum -= nums[l++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    
    public static void main(String[] args){
    	int[] nums = {2, 3, 1, 2, 4, 3};
    	int target = 7;
    	System.out.println(minSubArrayLen(target, nums));
    	System.out.println(minSubArrayLen2(target, nums));    	
    }

}
