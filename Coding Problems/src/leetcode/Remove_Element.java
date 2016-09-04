package leetcode;

public class Remove_Element {
	//https://leetcode.com/problems/remove-element/
    public static int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) nums[pos++] = nums[i];
        }
        return pos;
    }
    
    public static void main(String[] args){
    	int[] nums = {3,2,2,3};
    	System.out.println(removeElement(nums, 3));
    	for(int num : nums) System.out.print(num + ",");
    }
}
