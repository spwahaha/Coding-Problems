package leetcode;

public class Remove_Duplicates_from_Sorted_Array {
	//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public static int removeDuplicates(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,1,2,3,3};
    	System.out.println(removeDuplicates(nums));
    	for(int num : nums){
    		System.out.print(num+",");
    	}
    }
}
