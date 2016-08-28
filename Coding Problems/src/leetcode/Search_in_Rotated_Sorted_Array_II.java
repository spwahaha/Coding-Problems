package leetcode;

public class Search_in_Rotated_Sorted_Array_II {
    public static boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] <= nums[r]){
                if(nums[mid] == nums[r]) r--;
                else if(nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }else{
                if(nums[mid] == nums[l]) l++;
                else if(nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return false;
    }
    
    public static void main(String[] args){
    	int[] nums = {3, 3, 1, 3};
    	int target = 1;
    	System.out.println(search(nums, target));
    }
}
