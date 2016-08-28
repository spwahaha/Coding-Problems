package leetcode;

public class Find_Minimum_in_Rotated_Sorted_Array {
	//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] <= nums[r]){
                // right half is sorted
                if(mid == l || nums[mid] < nums[mid - 1]) return nums[mid];
                else r = mid - 1;
            }else l = mid + 1;
        }
        return -1;
    }
    
    public static void main(String[] args){
    	int[] nums1 = {3, 1, 2};
    	int[] nums2 = {5, 6, 7, 0, 1, 2, 3, 4};
    	System.out.println(findMin(nums1));
    	System.out.println(findMin(nums2));
    }
}
