package fb;

public class MaximumDrop {
	/*
	 * Given a list of number, there is only one peak or one drop. Find the maximum drop.
		Exps:
			1 -> 2 -> 3 -> 9 -> 3 -> 0 = 9;
			10 -> 4 -> 3 -> 8 = 7 ;
	 */
	
	public static int maximumDrop(int[] nums){
		if(nums == null || nums.length <= 1) return 0;
		int l = 0;
		int r = nums.length - 1;
		int len = nums.length;
		while(l <= r){
			int mid = l + (r - l) / 2;
			if(mid == 0 || mid == len - 1) return Math.abs(nums[0] - nums[len - 1]);
			if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
				return Math.max(Math.abs(nums[0] - nums[mid]), nums[len - 1] - nums[mid]);
			}else if(nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]){
				return Math.max(Math.abs(nums[0] - nums[mid]), nums[len - 1] - nums[mid]);
			}else{
				int k1 = nums[l + 1] - nums[l];
				int k2 = nums[mid + 1] - nums[mid];
				int k3 = nums[r] - nums[r - 1];
				if((k1 > 0 && k3 > 0) || (k1 < 0 && k3 < 0)){
					int max = Math.max(Math.abs(nums[0] - nums[l]), Math.abs(nums[0] - nums[r]));
					max = Math.max(max , Math.abs(nums[len - 1] - nums[l]));
					max = Math.max(max, Math.abs(nums[len - 1] - nums[r]));
					return max;
				}else{
					if((k1 > 0 && k2 > 0) || (k1 < 0 || k2 < 0)){
						l = mid + 1;
					}else{
						r = mid - 1;
					}
				}
			}
		}
		return 0;
	}
	
	public static int maximumDrop1(int[] nums){
		int len = nums.length;
		for(int i = 1; i < len - 1; i++){
			if((nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
					|| nums[i] < nums[i - 1] && nums[i] < nums[i + 1]){
				return Math.max(Math.abs(nums[0] - nums[i]), Math.abs(nums[len - 1] - nums[i]));
			}
		}
		return Math.abs(nums[0] - nums[len - 1]);
	}
	
	
    public static void main(String[] args) {
        System.out.println(maximumDrop(new int[]{1, 2, 3, 9, 3, 0}));
        System.out.println(maximumDrop(new int[]{1, 2, 3, 9, 3, 0}));
        System.out.println(maximumDrop(new int[]{10, 4, 3, 8}));
        System.out.println(maximumDrop(new int[]{10, 4, 3, 8}));
        
        System.out.println(maximumDrop1(new int[]{1, 2, 3, 9, 3, 0}));
        System.out.println(maximumDrop1(new int[]{1, 2, 3, 9, 3, 0}));
        System.out.println(maximumDrop1(new int[]{10, 4, 3, 8}));
        System.out.println(maximumDrop1(new int[]{10, 4, 3, 8}));
    }
}
