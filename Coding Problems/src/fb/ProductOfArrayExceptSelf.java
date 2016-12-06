package fb;

public class ProductOfArrayExceptSelf {
    //https://leetcode.com/problems/product-of-array-except-self/
	public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int left = 1;
        for(int i = 1; i < nums.length; i++){
            left = left * nums[i - 1];
            res[i] = left;
        }
        int right = nums[nums.length - 1];
        for(int j = nums.length - 2; j >= 0; j--){
            res[j] = res[j] * right;
            right = right * nums[j];
        }
        return res;
    }
}
