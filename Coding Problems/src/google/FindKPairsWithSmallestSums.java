package google;
import java.util.*;

public class FindKPairsWithSmallestSums {
	//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                return a1[0] + a1[1] - a2[0] - a2[1];
            }
        });
        for(int i = 0; i < k && i < nums1.length; i++){
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k-- > 0 && !pq.isEmpty()){
            int[] ar = pq.poll();
            res.add(new int[]{ar[0], ar[1]});
            if(ar[2] == nums2.length - 1) continue;
            pq.add(new int[]{ar[0], nums2[ar[2] + 1], ar[2] + 1});
        }
        return res;
    }
}
