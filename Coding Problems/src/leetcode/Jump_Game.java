package leetcode;

public class Jump_Game {
	//https://leetcode.com/problems/jump-game/
    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(max < i) return false;
            max = Math.max(i + nums[i], max);
        }
        return max >= nums.length - 1;
    }
    
    public static void main(String[] args){
    	int[] nums1 = {2,3,1,1,4};
    	int[] nums2 = {3,2,1,0,4};
    	System.out.println(canJump(nums1));
    	System.out.println(canJump(nums2));
    }
}
