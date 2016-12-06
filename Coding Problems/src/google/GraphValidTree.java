package google;
import java.util.*;

public class GraphValidTree {
	//https://leetcode.com/problems/graph-valid-tree/	
	
    public boolean validTree(int n, int[][] edges) {
        int[] ids = new int[n];
        for(int i = 0; i < n; i++){
            ids[i] = i;
        }
        
        for(int[] edge : edges){
            int r1 = root(edge[0], ids);
            int r2 = root(edge[1], ids);
            if(r1 == r2) return false;
            union(r1, r2, ids);
        }
        return edges.length == n - 1;
    }
    
    private int root(int i, int[] ids){
        while(ids[i] != i){
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }
    
    private void union(int i, int j, int[] ids){
        int r1 = root(i, ids);
        int r2 = root(j, ids);
        ids[r1] = r2;
    }
    
    public boolean validTree2(int n, int[][] edges) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new HashSet<Integer>());
        }
        
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> set = new HashSet<>();
        if(hasCycle(map, 0, -1, set)){
            return false;
        }
        return set.size() == n;
    }
    
    private boolean hasCycle(Map<Integer, Set<Integer>> map, int start, int from, Set<Integer> visited){
        if(visited.contains(start)) return true;
        visited.add(start);
        Set<Integer> set = map.get(start);
        for(Integer next : set){
            if(next == from) continue;
            if(hasCycle(map, next, start, visited)) return true;
        }
        return false;
    }
}
