package google;
import java.util.*;

public class FindMedianFromDataStream {
	//https://leetcode.com/problems/find-median-from-data-stream/
    PriorityQueue<Integer> smaller = new PriorityQueue<>();
    PriorityQueue<Integer> larger = new PriorityQueue<>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        larger.add(num);
        smaller.add(-larger.poll());
        if(smaller.size() > larger.size()){
            larger.add(-smaller.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(larger.size() > smaller.size()){
            return larger.peek();
        }else{
            return (larger.peek() - smaller.peek())/2.0;
        }
    }
    
    public static void main(String[] args){
    	FindMedianFromDataStream find = new FindMedianFromDataStream();
    	find.addNum(2);
    	find.addNum(3);
    	System.out.println(find.findMedian());
    }
    
}
