package fb;

public class RemoveDuplicatesFromSortedArray {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
	public static int removeDuplicates(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[pos - 1]){
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
	
	public static void main(String[] args){
		System.out.println(removeDuplicates(new int[]{1,1,2,2,3,3,4}));
	}
}
