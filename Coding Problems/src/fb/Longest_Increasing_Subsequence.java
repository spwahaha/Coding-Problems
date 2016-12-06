package fb;

public class Longest_Increasing_Subsequence {
	//https://leetcode.com/problems/longest-increasing-subsequence/
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] res = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            res[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
    
    public static int lengthOfLIS2(int[] nums) {
        //https://discuss.leetcode.com/topic/28738/java-python-binary-search-o-nlogn-time-with-explanation
        int[] tails = new int[nums.length];
        int size = 0;
        for(int num : nums){
            int l = 0;
            int r = size;
            while(l < r){
                int mid = l + (r - l) / 2;
                if(tails[mid] < num){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }
            tails[l] = num;
            if(l == size) size++;
        }
        return size;
    }
    
    public static void main(String[] args){
    	int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    	// result: 4 {2, 3, 7, 101}
    	System.out.println(lengthOfLIS(nums));
    	System.out.println(lengthOfLIS2(nums));
    }
}
