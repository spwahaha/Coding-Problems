package leetcode;

public class FindPeakElement {
    public static int findPeakElement(int[] nums) {
        if(nums == null) return -1;
        if(nums.length == 1) return 0;
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid == 0){
                if(nums[mid] > nums[mid + 1]) return mid;
                left = mid + 1;
            }else if(mid == len - 1){
                if(nums[mid] > nums[mid - 1]) return mid;
                right = mid - 1;
            }else if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }else if(nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args){
    	System.out.print(findPeakElement(new int[]{1,2,3,1}));
    }
    
    
}
