package google;

import java.util.*;

public class ZigzagIterator {
	//https://leetcode.com/problems/zigzag-iterator/
    Queue<Iterator> q;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if(!v1.isEmpty()) q.add(v1.iterator());
        if(!v2.isEmpty()) q.add(v2.iterator()); 
    }

    public int next() {
        Iterator it = q.poll();
        Integer next = (Integer)it.next();
        if(it.hasNext()) q.add(it);
        return next;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
    
    public static void main(String[] args){
    	List<Integer> list1 = Arrays.asList(1,2);
    	List<Integer> list2 = Arrays.asList(3,4,5,6);
    	ZigzagIterator zigzag = new ZigzagIterator(list1, list2);
    	while(zigzag.hasNext()){
    		System.out.println(zigzag.next());
    	}
    }
}
