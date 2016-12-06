package fb;

public class GetPeakOrValleyInedx {
	public static int getPeakOrValeyIndex(int[] nums){
		if(nums == null || nums.length <= 2) return 0;
		int len = nums.length;
		if(nums[len - 1] == nums[0]) return len / 2;
		else if(nums[len - 1] > nums[0]) return (len + nums[len - 1] - nums[0]) / 2;
		else return (len + nums[0] - nums[len - 1]) / 2;
	}
	
	public static int getPeakOrValeyIndex2(int[] nums){
		if(nums == null || nums.length <= 2) return 0;
		int left = 0;
		int right = nums.length - 1;
		int len = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(mid == 0 || mid == len - 1) return mid;
			else if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
			else if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) return mid;
			else if(Math.abs(nums[mid] - nums[left]) == mid - left){
				left = mid + 1;
			}else{
				right = mid - 1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args){
        System.out.println(getPeakOrValeyIndex(new int[]{1}));
        System.out.println(getPeakOrValeyIndex(new int[]{1, 2}));
        System.out.println(getPeakOrValeyIndex(new int[]{1, 0, 1}));
        System.out.println(getPeakOrValeyIndex(new int[]{1, 2, 1}));
        System.out.println(getPeakOrValeyIndex(new int[]{1, 2, 3, 4, 5, 4}));	

        System.out.println(getPeakOrValeyIndex2(new int[]{1}));
        System.out.println(getPeakOrValeyIndex2(new int[]{1, 2}));
        System.out.println(getPeakOrValeyIndex2(new int[]{1, 0, 1}));
        System.out.println(getPeakOrValeyIndex2(new int[]{1, 2, 1}));
        System.out.println(getPeakOrValeyIndex2(new int[]{1, 2, 3, 4, 5, 4}));	
	
	}
	
	
}
