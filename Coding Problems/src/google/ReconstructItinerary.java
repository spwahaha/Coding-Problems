package google;
import java.util.*;

public class ReconstructItinerary {
	//https://leetcode.com/problems/reconstruct-itinerary/
    public static List<String> findItinerary(String[][] tickets) {
        List<String> res = new LinkedList<>();
        if(tickets == null || tickets.length == 0) return res;
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            if(map.containsKey(ticket[0])){
                map.get(ticket[0]).add(ticket[1]);
            }else{
                PriorityQueue pq = new PriorityQueue<>();
                pq.add(ticket[1]);
                map.put(ticket[0], pq);
            }
        }
        helper(res, "JFK", map);
        return res;
    }
    
    private static void helper(List<String> res, String start, Map<String, PriorityQueue<String>> map){
        while(map.containsKey(start) && !map.get(start).isEmpty()){
            helper(res, map.get(start).poll(), map);
        }
        res.add(0, start);
    }
    
    public static void main(String[] args){
    	String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
    	System.out.println(findItinerary(tickets));
    }
}
