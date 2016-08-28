package leetcode;

public class Two_Sum_II_Input_array_is_sorted {
	//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length == 0) return res;
        int l = 0;
        int r = numbers.length - 1;
        while(l < r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }else if(sum < target) l++;
            else r--;
        }
        return res;
    }
    
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0) return res;
        for(int i = 0; i < nums.length - 1; i++){
            int num = nums[i];
            int idx2 = search(nums, i + 1, nums.length - 1, target - num);
            if(idx2 != -1){
                res[0] = i + 1;
                res[1] = idx2 + 1;
                return res;
            }
        }
        return res;
    }
    
    private static int search(int[] nums, int l, int r, int target){
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
    
    public static void main(String[] args){
    	int[] nums = {2, 3, 4};
    	int target = 6;
    	int[] res1 = twoSum(nums, target);
    	System.out.println("" + res1[0] + "," + res1[1]);
    	int[] res2 = twoSum(nums, target);
    	System.out.println("" + res2[0] + "," + res2[1]);    	
    }
}
