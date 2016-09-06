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
    
    public static void main(String[] args){
    	int[][] nums = {{1,2},{3,5},{6,7},{8,10},{12,16}};
    	List<Interval> list = new ArrayList<Interval>();
    	for(int[] num : nums) list.add(new Interval(num[0], num[1]));
    	Interval newInterval = new Interval(4,9);
    	System.out.println(insert(list, newInterval));
    }
    
    
}
