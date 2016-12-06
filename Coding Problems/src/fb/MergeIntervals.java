package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import leetcode.Interval;

public class MergeIntervals {
	//https://leetcode.com/problems/merge-intervals/
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(int i = 0; i < intervals.size() - 1; i++){
            if(intervals.get(i).end < intervals.get(i + 1).start) continue;
            intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i + 1).end);
            intervals.remove(i + 1);
            i--;
        }
        return intervals;
    }
    
    public List<Interval> merge2(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval interval = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(interval.end >= intervals.get(i).start){
                interval.end = Math.max(interval.end, intervals.get(i).end);
            }else{
                res.add(interval);
                interval = intervals.get(i);
            }
        }
        res.add(interval);
        return res;
    }
    
    public static List<Interval> merge3(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return res;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval interval = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(interval.end >= intervals.get(i).start){
                interval = new Interval(Math.min(interval.start, intervals.get(i).start),
                                        Math.max(interval.end, intervals.get(i).end));
            }else{
                res.add(interval);
                interval = intervals.get(i);
            }
        }
        res.add(interval);
        return res;
    }
    
    public static void main(String[] args){
    	Interval i1 = new Interval(1, 3);
    	Interval i2 = new Interval(2, 4);
    	System.out.println(merge3(Arrays.asList(i1, i2)));
    }
    
}
