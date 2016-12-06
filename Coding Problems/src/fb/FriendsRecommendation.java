package fb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class FriendsRecommendation {
    public List<Integer> friendsRecommendation(Person person) {
    	List<Integer> list = new ArrayList<Integer>();
    	HashMap<Integer, Integer> map = new HashMap<>();
    	for(Person friend : person.frineds){
    		for(Person f : friend.frineds){
    			if(f.id == person.id) continue;
    			map.put(f.id, map.containsKey(f.id) ? map.get(f.id) + 1 : 1);
    		}
    	}
    	PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
    		public int compare(int[] p1, int[] p2){
    			return p2[1] - p1[1];
    		}
    	});
    	for(int key : map.keySet()){
    		pq.add(new int[]{key, map.get(key)});
    	}
    	while(!pq.isEmpty()){
    		list.add(pq.poll()[0]);
    	}
    	return list;
    }

}
