package fb;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums){
            if(map.containsKey(num)) continue;
            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            int len = left + right + 1;
            map.put(num, len);
            map.put(num - left, len);
            map.put(num + right, len);
            max = Math.max(max, len);
        }
        return max;
    }
    
    public static void main(String[] args){
    	System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
