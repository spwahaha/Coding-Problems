package google;

import java.util.ArrayList;
import java.util.List;

public class MissingRange {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower;
        for(int i = 0; i < nums.length; i++){
            if(next < nums[i]){
                res.add(range(next, nums[i] - 1));
                next = nums[i] + 1;
            }else if(next == nums[i]){
                next++;
                continue;
            }
        }
        if(next <= upper){
            res.add(range(next, upper));
        }
        return res;
    }
    
    private static String range(int lower, int upper){
        if(lower == upper) return "" + lower;
        else return "" + lower + "->" + upper;
    }
    
    public static void main(String[] args){
    	System.out.println(findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
    }
}
