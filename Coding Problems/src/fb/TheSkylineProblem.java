package fb;

import java.util.ArrayList;
import java.util.List;

public class TheSkylineProblem {
	//https://leetcode.com/problems/the-skyline-problem/
    public List<int[]> getSkyline(int[][] buildings) {
        if(buildings.length == 0) return new ArrayList<int[]>();
        return skyline(buildings, 0, buildings.length - 1);
    }
    
    private ArrayList<int[]> skyline(int[][] buildings, int p, int q){
        if(p < q){
            int mid = p + (q - p) / 2;
            return merge(skyline(buildings, p, mid), skyline(buildings, mid + 1, q));
        }else{
            ArrayList<int[]> res = new ArrayList<>();
            res.add(new int[] {buildings[p][0], buildings[p][2]});
            res.add(new int[] {buildings[p][1], 0});
            return res;
        }
    }
    
    private ArrayList<int[]> merge(ArrayList<int[]> l1, ArrayList<int[]> l2){
        ArrayList<int[]> res = new ArrayList<>();
        int h1 = 0;
        int h2 = 0;
        while(l1.size() > 0 && l2.size() > 0){
            int x = 0;
            int h = 0;
            if(l1.get(0)[0] < l2.get(0)[0]){
                x = l1.get(0)[0];
                h1 = l1.get(0)[1];
                h = Math.max(h1, h2);
                l1.remove(0);
            }else if(l1.get(0)[0] > l2.get(0)[0]){
                x = l2.get(0)[0];
                h2 = l2.get(0)[1];
                h = Math.max(h1, h2);
                l2.remove(0);
            }else{
                x = l1.get(0)[0];
                h1 = l1.get(0)[1];
                h2 = l2.get(0)[1];
                h = Math.max(h1, h2);
                l1.remove(0);
                l2.remove(0);
            }
            if(res.size() == 0 || h != res.get(res.size() - 1)[1]){
                res.add(new int[]{x, h});
            }
        }
        res.addAll(l1);
        res.addAll(l2);
        return res;
    }
}
