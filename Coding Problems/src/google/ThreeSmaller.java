package google;
import java.util.*;

public class ThreeSmaller {
	//https://leetcode.com/problems/3sum-smaller/
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int cnt = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] < target){
                    cnt += r - l;
                    l++;
                }else{
                    r--;
                }
            }
        }
        return cnt;
    }
}
