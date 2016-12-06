package google;

import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
	//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
	public static int countComponents(int n, int[][] edges) {
        int[] ids = new int[n];
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            ids[i] = i;
        }
        for(int[] edge : edges){
            union(edge[0], edge[1], ids);
        }
        for(int i = 0; i < n; i++){
            set.add(root(i, ids));
        }
        return set.size();
    }
    
    private static void union(int i, int j, int[] ids){
        int r1 = root(i, ids);
        int r2 = root(j, ids);
        ids[r1] = r2;
    }
    
    private static int root(int i, int[] ids){
        while(i != ids[i]){
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
    
    public static void main(String[] args){
    	System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}
