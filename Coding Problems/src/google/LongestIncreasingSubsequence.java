package google;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int len = 1;
        tails[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < tails[0]){
                tails[0] = nums[i];
            }else if(nums[i] > tails[len - 1]){
                tails[len++] = nums[i];
            }else{
                tails[bs(tails, 0, len - 1, nums[i])] = nums[i];
            }
        }
        return len;
    }
    
    private static int bs(int[] tails, int start, int end, int target){
        //smallest index tails[index] >= target 
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(tails[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    
    public static void main(String[] args){
    	int[] nums = {10,9,2,5,3,7,101,18};
    	System.out.println(lengthOfLIS(nums));
    }
}
