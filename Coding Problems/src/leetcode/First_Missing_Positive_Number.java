package leetcode;

public class First_Missing_Positive_Number {
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i + 1!= nums[i]) return i + 1;
        }
        return nums.length + 1;
    }
    
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {3,4,-1,1};
    	System.out.println(firstMissingPositive(nums));
    }
}
