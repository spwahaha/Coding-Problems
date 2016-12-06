package google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
	//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>(new Comparator<Tuple>(){
           public int compare(Tuple t1, Tuple t2){
               return t1.array[t1.p] - t2.array[t2.p];
           } 
        });
        
        for(int[] line : matrix){
            pq.add(new Tuple(line));
        }
        
        for(int i = 0; i < k - 1; i++){
            Tuple tuple = pq.poll();
            tuple.p++;
            if(tuple.p < tuple.array.length){
                pq.add(tuple);
            }
        }
        Tuple tp = pq.peek();
        return tp.array[tp.p];
    }
    
    static class Tuple{
        int[] array;
        int p;
        public Tuple(int[] ar){
            this.array = ar;
            p = 0;
        }
    }
    
    public static void main(String[] args){
    	System.out.println(kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 14, 15}}, 8));
    }
}
