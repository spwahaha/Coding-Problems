package fb;
import java.util.*;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(nums, res, list, 0, new HashSet<Integer>());
        return res;
    }
    
    private static void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int start, HashSet<Integer> set){
        res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1] && !set.contains(i - 1)) continue;
            list.add(nums[i]);
            set.add(i);
            helper(nums, res, list, i + 1, set);
            set.remove(i);
            list.remove(list.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        int start = 0;
        int size = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] == nums[i - 1]){
                start = size;
            }else{
                start = 0;
            }
            size = res.size();
            for(int j = start; j < size; j++){
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}
