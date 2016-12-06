package fb;

public class HIndexII {
    public static int hIndex(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            // index = nums[mid], number of papers above and includes this one, len - mid + 1
            if(len - mid == nums[mid]) return nums[mid];
            else if(nums[mid] > len - mid) r = mid - 1;
            else l = mid + 1;
        }
        return len - l;
    }
    
    public static void main(String[] args){
    	System.out.println(hIndex(new int[]{0, 1, 3, 5, 6}));
    }
}
