package microsoft;

public class RotateArray {
	//https://leetcode.com/problems/rotate-array/
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k % nums.length == 0) return;
        k = k % nums.length;
        rotate(nums, 0, nums.length - k - 1);
        rotate(nums, nums.length - k, nums.length - 1);
        rotate(nums, 0, nums.length - 1);
    }
    
    private void rotate(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
