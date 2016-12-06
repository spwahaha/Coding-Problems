package google;

public class PatchingArray {
    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0;
        int i = 0;
        while(miss <= n){
            if(i < nums.length && nums[i] <= miss){
                miss += nums[i++];
            }else{
                miss += miss;
                added++;
            }
        }
        return added;
    }
    
    public static void main(String[] args){
    	int[] nums = {1,2,31,33};
    	System.out.println(minPatches(nums, 2147483647));
    }
}
