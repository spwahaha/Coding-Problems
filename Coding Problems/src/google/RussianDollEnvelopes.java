package google;
import java.util.*;

public class RussianDollEnvelopes {
	//https://leetcode.com/problems/russian-doll-envelopes/
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] e1, int[] e2){
                if(e1[0] - e2[0] != 0){
                    return e1[0] - e2[0];
                }else{
                    return e2[1] - e1[1];
                }
            }
        });   
        int[] nums = new int[envelopes.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = envelopes[i][1];
            // System.out.println(envelopes[i][0] + "  " + envelopes[i][1]);
        }
        int[] f = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
            for(int j = i; j >= 0; j--){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
