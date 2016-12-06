package fb;

public class Snippet {
	public void sortColors(int[] nums) {
	    // (0~left] is 0, (left, i] is 1, (i, right) unknown, [right, nums.length - 1) 2 
	    int left = 0;
	    int right = nums.length - 1;
	    int i = 0;
	    while(i <= right){
	        if(nums[i] == 0){
	            swap(nums, left++, i++);
	        }else if(nums[i] == 1){
	            i++;
	        }else{
	            swap(nums, right--, i);
	        }
	    }
	}
	
	private void swap(int[] nums, int i, int j){
	    int temp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = temp;
	}
}

