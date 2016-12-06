package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
	//https://leetcode.com/problems/insert-interval/
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || newInterval == null) return res;
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i++));
        }
        while(i < intervals.size() && newInterval.end >= intervals.get(i).start){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start),
                                    Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()) res.add(intervals.get(i++));
        return res;
    }
    
    public static List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        if(newInterval == null) return intervals;
        int index = 0;
        boolean added = false;
        while(index < intervals.size() && intervals.get(index).end < newInterval.start){
            index++;
        }
        intervals.add(index, newInterval);
        while(index < intervals.size() - 1 && intervals.get(index + 1).start <= newInterval.end){
        	intervals.get(index).start = Math.min(intervals.get(index + 1).start, newInterval.start);
        	intervals.get(index).end = Math.max(intervals.get(index + 1).end, newInterval.end);
            intervals.remove(index + 1);
        }
        return intervals;
    }
    
    public static void main(String[] args){
    	int[][] nums = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    	List<Interval> list = new ArrayList<Interval>();
    	for(int[] num : nums) list.add(new Interval(num[0], num[1]));
    	Interval newInterval = new Interval(4,9);
    	System.out.println(insert2(list, newInterval));
    }
    
    
}
