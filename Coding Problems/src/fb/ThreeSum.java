package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
	//https://leetcode.com/problems/3sum/
	
	/*
	 * Two pointer
	 * T: O(n^2) S: O(1);
	 */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    while(j < k && nums[j] == nums[j + 1]) j++;
                    while(j < k && nums[k] == nums[k - 1]) k--;
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                }else if(sum < target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
    
    /*
     * Hasmap
     * T: O(n^2) S: O(n)
     */
    public static List<List<Integer>> threeSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int rest = target - nums[i] - nums[j];
                int cnt = 0;
                if(nums[i] == rest) cnt++;
                if(nums[j] == rest) cnt++;
                if(map.containsKey(rest) && map.get(rest) > cnt && rest >= nums[j]){
                    res.add(Arrays.asList(nums[i], nums[j], rest));
                }
            }
        }
        return res;
    }
    
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r--]));
                    while(l < r && nums[l + 1] == nums[l]) l++;
                    while(r > l && nums[r - 1] == nums[r]) r--;
                }else if(sum < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
    
    public static void main(String[] arg) {
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, 4}, 0));
//        System.out.println(threeSum2(new int[]{-1, 0, 1, 2, -1, 4}, 0));
        System.out.println(threeSum3(new int[]{-1, 0, 1, 2, -1, 4}));

        System.out.println(threeSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(threeSum2(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(threeSum3(new int[]{0, 0, 0, 0, 0}));


        System.out.println(threeSum2(new int[]{1}, 3));
        System.out.println(threeSum3(new int[]{1}));
    }
}
