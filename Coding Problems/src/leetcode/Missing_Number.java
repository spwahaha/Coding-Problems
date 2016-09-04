package leetcode;

public class Missing_Number {
    public static int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] < nums.length && i != nums[i]){
            	swap(nums, i, nums[i]);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i) return i;
        }
        return nums.length;
    }
    
    private static void swap(int[] nums, int i, int j){
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
    
    
    public static void main(String[] args){
    	int[] nums = {1, 0};
    	System.out.println(missingNumber(nums));
    }
}
