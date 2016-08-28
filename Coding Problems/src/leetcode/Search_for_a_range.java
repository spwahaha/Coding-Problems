package leetcode;

public class Search_for_a_range {
	//https://leetcode.com/problems/search-for-a-range/
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;
        // lower bound binary search
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target) l = mid + 1;
            // consider what would happen if nums[mid] == target
            // nums[mid] >= target. if nums[mid] == target, and loop terminate at the next loop, then l is the result 
            else r = mid - 1;
        }
        if(l < 0 || l > nums.length - 1 || nums[l] != target) return res;
        res[0] = l;
        // upper bound binary search
        l = 0;
        r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        res[1] = r;
        return res;
    }
}
