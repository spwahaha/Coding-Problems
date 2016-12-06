package leetcode;

public class IncreasingTripletSubsequence {
	//https://leetcode.com/problems/increasing-triplet-subsequence/
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length <= 2) return false;
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > max) return true;
            if(num > min){
                max = num;
            }else{
                min = num;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	System.out.println(increasingTriplet(new int[]{1,2,3,4,5}));
    }
}
