package google;
import java.util.*;

public class PeekingIterator implements Iterator<Integer>{
	//https://leetcode.com/problems/peeking-iterator/
    private Integer next;
    private Iterator<Integer> it;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator;
	    if(it.hasNext()){
	        next = it.next();
	    }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = next;
	    next = null;
	    if(it.hasNext()){
	        next = it.next();
	    }
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
	
	public static void main(String[] args){
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		PeekingIterator it = new PeekingIterator(list.iterator());
		System.out.println(it.peek());
		System.out.println(it.next());
		System.out.println(it.peek());
		System.out.println(it.next());
	}
}
