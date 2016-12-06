package leetcode;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int pivot = partition(nums, start, end);
            if(pivot == k - 1) return nums[pivot];
            else if(pivot < k - 1) start = pivot + 1;
            else end = pivot - 1;
        }
        return -1;
    }
    
    private static int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int l = start + 1;
        int h = end;
        while(l <= h){
            while(l < end && nums[l] >= pivot){
                l++;
            }
            while(h > start && nums[h] <= pivot){
                h--;
            }
            if(l >= h) break;
            swap(nums, l, h);
        }
        swap(nums, start, h);
        return h;
    }
    
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args){
    	System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
