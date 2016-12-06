package fb;

import java.util.HashSet;
import java.util.Set;

import leetcode.Utilis;

public class IntersectionOfTwoArrays {
	//https://leetcode.com/problems/intersection-of-two-arrays/
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> res = new HashSet<Integer>();
        for(int num : nums2){
            if(set.contains(num)) res.add(num);
        }
        int[] nums = new int[res.size()];
        int i = 0;
        for(int num : res){
            nums[i++] = num;
        }
        return nums;
    }
    
    public static void main(String[] args){
    	Utilis.printArray(intersection(new int[]{1,2,2,1}, new int[]{2,2}));
    }
}
