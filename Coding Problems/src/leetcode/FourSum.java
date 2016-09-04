package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int m = j + 1;
                int n = nums.length - 1;
                while(m < n){
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while(m < n && nums[m] == nums[m + 1]) m++;
                        while(m < n && nums[n] == nums[n - 1]) n--;
                        m++;
                        n--;
                    }else if(sum < target) m++;
                    else n--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	int[] nums = {1, 0, -1, 0, -2, 2, -1};
    	System.out.println(fourSum(nums, 0));
    }
}
