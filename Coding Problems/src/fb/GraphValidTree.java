package fb;
import java.util.*;

public class GraphValidTree {
    //https://leetcode.com/problems/graph-valid-tree/
	public boolean validTree(int n, int[][] edges) {
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
