package google;
import java.util.*;

import leetcode.Utilis;

public class SlidingWindowMaximum {
	//https://leetcode.com/problems/sliding-window-maximum/
    //O(nlg(k))
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length < k) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(i < k - 1){
                pq.add(-nums[i]);
            }else{
                pq.add(-nums[i]);
                res[index++] = -pq.peek();
                pq.remove(-nums[i - k + 1]);
            }
        }
        return res;
    }
    
    /*
     * Linear Time complexity 
     * O(n)
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || k <= 0) return new int[0];
        int n = nums.length;
        int [] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            while(!q.isEmpty() && q.peek() < i - k + 1){
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i >= k - 1){
                r[ri++] = nums[q.peek()];
            }
        }
        return r;
    }
    
    public static void main(String[] args){
    	Utilis.printArray(maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
}
