package fb;

import java.util.*;

public class SubsetProducts {

	public static List<Integer> subsetProduct(int[] nums){
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < nums.length; i++){
			int size = res.size();
			for(int j = 0; j < size; j++){
				res.add(res.get(j) * nums[i]);
			}
			res.add(nums[i]);
		}
		return new ArrayList<>(new HashSet<>(res));
	}
	
	public static List<Integer> subsetProduct2(int[] nums){
		List<Integer> res = new ArrayList<>();
		dfs2(res, nums, 0, new HashSet<Integer>(), 1);
		res.remove(0);
		return new ArrayList<>(new HashSet<>(res));
	}
	
	private static void dfs2(List<Integer> res, int[] nums, int start, HashSet<Integer> set, int value){
		res.add(value);
		for(int i = start; i < nums.length; i++){
			if(set.contains(i)) continue;
			set.add(i);
			dfs2(res, nums, i + 1, set, value * nums[i]);
			set.remove(i);
		}
	}
	
	public static List<Integer> subsetProduct3(int[] nums){
		return dfs3(nums, 0);
	}
	
	private static List<Integer> dfs3(int[] nums, int start){
		if(start == nums.length) return new ArrayList<>();
		List<Integer> list = dfs3(nums, start + 1);
		List<Integer> res = new ArrayList<>();
		for(int i = 0; i < list.size(); i++){
			res.add(list.get(i) * nums[start]);
		}
		res.addAll(list);
		res.add(nums[start]);
		return new ArrayList<>(new HashSet<Integer>(res));
	}
	
	
    public static void main(String[] args) {
        System.out.println(subsetProduct(new int[]{2, 3, 5}));
        System.out.println(subsetProduct2(new int[]{2, 3, 5}));
        System.out.println(subsetProduct3(new int[]{2, 3, 5}));
        System.out.println(subsetProduct(new int[]{1, 2, 3, 5}));
        System.out.println(subsetProduct2(new int[]{1, 2, 3, 5}));
        System.out.println(subsetProduct3(new int[]{1, 2, 3, 5}));
    }
}
