package fb;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubArraySumEqualsK {
    public static int maxSubArrayLen(int[] nums, int k) {
        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k) max = i + 1;
            else if(map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return max;
    }
    
    public static void main(String[] args){
    	System.out.println(maxSubArrayLen(new int[]{1,1,0}, 1));
    }
}
