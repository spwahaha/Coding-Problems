package google;
import java.util.*;
public class SummaryRanges {
	//https://leetcode.com/problems/summary-ranges/
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1] + 1){
                res.add(getRange(start, nums[i - 1]));
                start = nums[i];
            }
        }
        res.add(getRange(start, nums[nums.length - 1]));
        return res;
    }
    
    private static String getRange(int start, int end){
        if(start == end) return ""+start;
        return "" + start + "->" + end;
    }
    
    public static void main(String[] args){
    	System.out.println(summaryRanges(new int[]{1,2,3,4,6,7}));
    }
}
