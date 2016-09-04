package leetcode;

public class Next_Permutation {
	//https://leetcode.com/problems/next-permutation/
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int idx = nums.length - 1;
        while(idx > 0){
            if(nums[idx] > nums[idx - 1]) break;
            idx--;
        }
        if(idx == 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int val = nums[idx - 1];
        for(int i = nums.length - 1; i >= idx; i--){
            if(nums[i] > val) {
                swap(nums, i, idx - 1);
                break;
            }
        }
        reverse(nums, idx, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i++, j--);
        }
    }
    
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,3,2,5,4,3,2,1};
    	nextPermutation(nums);
    	for(int num : nums) System.out.print(num + ",");
    }
}
