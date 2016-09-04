package others;

public class MissingNumber {
	// suppose 1-n in array with length n, one number missing, one number repeat once
	public static int findMissingNumber(int[] nums) {
	    if (nums == null || nums.length <= 1) {
	        return -1;
	    }

	    int i = 0;
	    int repeatIndex = -1;
	    while (i < nums.length) {
	        if (nums[nums[i] - 1] != nums[i]) {
	        	// examine whether nums[i] is the same as the number where it should be
	        	// if not, put it where it should be
	        	// if so, two cases: 1. nums[i] - 1 == i, it's in the right place
	        	// 2. nums[nums[i] - 1] == nums[i], repeated one. {1, 1, 2} 
	        	int temp = nums[nums[i] - 1];
	            nums[nums[i] - 1] = nums[i];
	            nums[i] = temp;
	        }
	        else if (nums[i] - 1 == i) {
	        	// number is in the right place
	            i++;
	        }
	        else {
	            repeatIndex = i;
	            i++;
	        }
	    }

	    return repeatIndex + 1;
	}

	public static void main(String[] args) {
	    int[] nums = new int[]{1, 1, 4, 3};
	    int ret = findMissingNumber(nums);
	    System.out.print(ret);
	}
}
