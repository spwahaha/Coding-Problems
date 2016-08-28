package leetcode;

public class Find_Peak_Element {
	//https://leetcode.com/problems/find-peak-element/
    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1]) return mid;
                else l = mid + 1;
            }else if(mid == nums.length - 1){
                if(nums[mid] > nums[mid - 1]) return mid;
                else r = mid - 1;
            }else if(nums[mid] > nums[mid - 1]){
                // peak or up slope
                if(nums[mid] > nums[mid + 1]) return mid;
                else l = mid + 1;
            }else{
                // down slop
                r = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
    	int[] nums = {1, 2, 3, 1};
    	System.out.println(findPeakElement(nums));
    }
}
