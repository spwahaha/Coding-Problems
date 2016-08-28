package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Russian_Doll_Envelopes {
	//https://leetcode.com/problems/russian-doll-envelopes/
    public static  int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] env1, int[] env2){
                if(env1[0] < env2[0]) return -1;
                if(env1[0] > env2[0]) return 1;
                if(env1[1] < env2[1]) return 1;
                if(env1[1] > env2[1]) return -1;
                return 0;
            }
        });
        int[] nums = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            nums[i] = envelopes[i][1];
        }
        int[] f = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            f[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        return max;
    }
    
    public static void main(String[] args){
    	int[][] nums = {{5,4},{6,4},{6,7},{2,3}};
    	System.out.println(maxEnvelopes(nums));
    }
}
