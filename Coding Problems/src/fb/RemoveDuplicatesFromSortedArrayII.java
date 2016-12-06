package fb;

public class RemoveDuplicatesFromSortedArrayII {
	//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    public static int removeDuplicates(int[] nums) {
        int pos = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < 2 || nums[i] > nums[pos - 2]){
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }
    
    public static void main(String[] args){
    	System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
