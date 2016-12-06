package microsoft;

public class MissingNumber {
	//https://leetcode.com/problems/missing-number/
    public static int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] < nums.length && nums[i] != i){
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
    	missingNumber(new int[]{0,1,3});
    }
}
