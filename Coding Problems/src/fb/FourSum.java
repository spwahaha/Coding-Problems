package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FourSum {
	//https://leetcode.com/problems/4sum/
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        while(l < r && nums[l] == nums[l + 1]) l++;
                        while(l < r && nums[r] == nums[r - 1]) r--;
                        res.add(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
    
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        
        for(int i = 0; i < nums.length - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k = j + 1; k < nums.length - 1; k++){
                    if(k != j + 1 && nums[k] == nums[k - 1]) continue;
                    int rest = target - nums[i] - nums[j] - nums[k];
                    int cnt = 0;
                    if(nums[i] == rest) cnt++;
                    if(nums[j] == rest) cnt++;
                    if(nums[k] == rest) cnt++;
                    if(map.containsKey(rest) && map.get(rest) > cnt && rest >= nums[k]){
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], rest));
                    }
                }
            }
        }
        return res;
    }
    
    public static void main(String[] arg) {
        System.out.println(fourSum(new int[]{4, 3, 2, 1, 0, 0, -1}, 3));
        System.out.println(fourSum2(new int[]{4, 3, 2, 1, 0, 0, -1}, 3));
    }
}
