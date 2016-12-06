package fb;

import leetcode.Utilis;

public class MoveZeros {
	//https://leetcode.com/problems/move-zeroes/
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[pos++] = nums[i];
            }
        }
        for(int i = pos; i < nums.length; i++){
            nums[i] = 0;
        }
    }
    
    /*
     * 
     */
    
    public static void main(String[] args){
    	int[] nums = {0, 1, 0, 3, 12};
    	moveZeroes(nums);
    	Utilis.printArray(nums);
    }
}
