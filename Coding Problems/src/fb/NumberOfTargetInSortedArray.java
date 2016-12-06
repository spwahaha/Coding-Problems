package fb;

public class NumberOfTargetInSortedArray {
    public static int numberofTargetNumberinSortedArray(int[] nums, int target) {
    	if(nums == null || nums.length == 0) return 0;
    	int start = 0;
    	int end = 0;
    	int l = 0;
    	int r = nums.length - 1;
    	while(l <= r){
    		int mid = l + (r - l) / 2;
    		if(target <= nums[mid]){
    			r = mid - 1;
    		}else{
    			l = mid + 1;
    		}
    	}
    	if(l == -1) return 0;
    	if(nums[l] != target) return 0;
    	start = l;
    	l = 0;
    	r = nums.length - 1;
    	while(l <= r){
    		int mid = l + (r - l) / 2;
    		if(target >= nums[mid]){
    			l = mid + 1;
    		}else{
    			r = mid - 1;
    		}
    	}
    	end = r;
    	return end - start + 1;
    }
    
    public static void main(String[] arg) {
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 0));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 1));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 2));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 3));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 4));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 5));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 8));
        System.out.println(numberofTargetNumberinSortedArray(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5, 6, 9}, 9));
    }

}
