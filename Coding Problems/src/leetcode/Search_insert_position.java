package leetcode;

public class Search_insert_position {
	//https://leetcode.com/problems/search-insert-position/
	// lower bound binary search
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
    
    public static void main(String[] args){
    	int[] nums = {1, 3, 5, 6};
    	System.out.println(searchInsert(nums, 5));
    	System.out.println(searchInsert(nums, 2));
    	System.out.println(searchInsert(nums, 7));
    	System.out.println(searchInsert(nums, 0));
    }
}
