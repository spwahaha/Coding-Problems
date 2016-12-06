package fb;
import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        helper(nums, res, list, 0, new HashSet<Integer>());
        return res;
    }
    
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int start, HashSet<Integer> set){
        res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
//            if(set.contains(i)) continue;
            set.add(i);
            list.add(nums[i]);
            helper(nums, res, list, i + 1, set);
            set.remove(i);
            list.remove(list.size() - 1);
        }
    }
    
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int total = (int)Math.pow(2, nums.length);
        for(int i = 0; i < total; i++){
            List<Integer> list = new ArrayList<>();
            int num = i;
            for(int j = 0; j < nums.length; j++){
                if((num & 1) == 1){
                    list.add(nums[j]);
                }
                num = num >> 1;
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
    
    public static List<List<Integer>> subsets3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(subsets(new int[]{1,2,3}));
    	System.out.println(subsets2(new int[]{1,2,3}));
    	System.out.println(subsets3(new int[]{1,2,3}));
    }
}
