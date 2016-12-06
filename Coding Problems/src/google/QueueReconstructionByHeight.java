package google;
import java.util.*;

import leetcode.Utilis;

public class QueueReconstructionByHeight {
	//https://leetcode.com/problems/queue-reconstruction-by-height/
    public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
           public int compare(int[] a1, int[] a2){
               if(a1[0] == a2[0]){
                    return a1[1] - a2[1];
                }else{
                    return a2[0] - a1[0];
                }
           } 
        });
        for(int[] peo : people){
            pq.add(peo);
        }
        List<int[]> res = new ArrayList<>();
        while(!pq.isEmpty()){
            int[] peo = pq.poll();
            res.add(peo[1], peo);
        }
        return res.toArray(new int[people.length][2]);
    }
    
    public static void main(String[] args){
    	int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    	Utilis.printArray(reconstructQueue(people));
    }
    
}
