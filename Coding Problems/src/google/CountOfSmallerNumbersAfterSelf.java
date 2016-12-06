package google;
import java.util.*;

import leetcode.Utilis;

public class CountOfSmallerNumbersAfterSelf {
	//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            int pos = insertPosi(sorted, nums[i]);
            ans[i] = pos;
            sorted.add(pos, nums[i]);
        }
        return Arrays.asList(ans);
    }
    
    private static int insertPosi(List<Integer> sorted, int target){
        int l = 0;
        int r = sorted.size() - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target <= sorted.get(mid)) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
    
    static int[] index;
    static int[] counts;
    public static List<Integer> countSmaller2(int[] nums){
    	int len = nums.length;
    	index = new int[len];
    	counts = new int[len];
    	for(int i = 0; i < len; i++){
    		index[i] = i;
    	}
    	mergesort(nums, 0, len - 1);
    	List<Integer> res = new ArrayList<>();
    	for(int cnt : counts){
    		res.add(cnt);
    	}
    	return res;
    }
    
    private static void mergesort(int[] nums, int start, int end){
    	if(start >= end) return;
    	int mid = start + (end - start) / 2;
    	mergesort(nums, start, mid);
    	mergesort(nums, mid + 1, end);
    	merge(nums, start, mid, end);
    }
    
    private static void merge(int[] nums, int start, int mid, int end){
    	int[] ar = new int[nums.length];
    	for(int i = start; i <= end; i++){
    		ar[i] = nums[i];
    	}
    	int cnt = 0;
    	int[] tempIndex = new int[nums.length];
    	// 5, 2 index[1] = 0
    	for(int i = start; i <= end; i++){
    		tempIndex[i] = index[i];
    	}
    	int p = start;
    	int p1 = start;
    	int p2 = mid + 1;
    	while(p1 <= mid && p2 <=end){
    		if(ar[p2] < ar[p1]){
    			cnt++;
    			index[p] = tempIndex[p2];
    			nums[p++] = ar[p2++];
    		}else{
    			index[p] = tempIndex[p1];
    			counts[index[p]] += cnt;
    			nums[p++] = ar[p1++];
    		}
    	}
    	
    	while(p2 <= end){
    		index[p] = tempIndex[p2];
    		nums[p++] = ar[p2++];
    	}
    	
    	while(p1 <= mid){
    		index[p] = tempIndex[p1];
    		counts[index[p]] += cnt;
    		nums[p++] = ar[p1++];
    	}  	
    }
    
    
    public static void main(String[] args){
    	System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    	System.out.println(countSmaller2(new int[]{5, 2, 6, 1}));
    	Utilis.printArray(index);
    	System.out.println(countSmaller2(new int[]{2, 0, 1}));
    	Utilis.printArray(index);
    }
    
}
