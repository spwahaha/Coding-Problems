package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
	//https://leetcode.com/problems/merge-intervals/
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval inter = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(overlap(inter, intervals.get(i))){
                inter = merge(inter, intervals.get(i));
            }else{
                res.add(inter);
                inter = intervals.get(i);
            }
        }
        res.add(inter);
        return res;
    }
    
    private static boolean overlap(Interval i1, Interval i2){
        return i1.end >= i2.start;
    }
    
    private static Interval merge(Interval i1, Interval i2){
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
    
    public static void main(String[] args){
    	Interval i1 = new Interval(1,3);
    	Interval i2 = new Interval(2,6);
    	Interval i3 = new Interval(8,10);
    	Interval i4 = new Interval(15,18);
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(i1);
    	intervals.add(i2);
    	intervals.add(i3);
    	intervals.add(i4);
    	System.out.println(merge(intervals));
    }
}
