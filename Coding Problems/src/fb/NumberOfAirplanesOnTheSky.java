 	package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import leetcode.Interval;

public class NumberOfAirplanesOnTheSky {
	//http://www.lintcode.com/en/problem/number-of-airplanes-in-the-sky/
	
	/*
	 * Using heap
	 * O(n*lg(n))
	 */
	public static int countOfAirplanes(List<Interval> airplains) { 
        // write your code here
        if(airplains == null || airplains.size() == 0) return 0;
        Collections.sort(airplains, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(airplains.size(), new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });
        
        pq.add(airplains.get(0));
        for(int i = 1; i < airplains.size(); i++){
            Interval interval = pq.poll();
            if(airplains.get(i).start >= interval.end){
                // next start is behind this end, can use the same root
                interval.end = airplains.get(i).end;
            }else{
                pq.add(airplains.get(i));
            }
            pq.add(interval);
        }
        return pq.size();
    }
	
	/*
	 * sort start time and end time
	 * 
	 */
    public static int countOfAirplanes2(List<Interval> airplanes) { 
        // write your code here
        int[] start = new int[airplanes.size()];
        int[] end = new int[airplanes.size()];
        for(int i = 0; i < airplanes.size(); i++){
            start[i] = airplanes.get(i).start;
            end[i] = airplanes.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int cnt = 0;
        int j = 0;
        for(int i = 0; i < start.length; i++){
            if(start[i] >= end[j]){
            	// start later than the end, then update the latest end
                j++;
            }else{
            	// start < end, need another room
                cnt++;
            }            
        }
        return cnt;
    }
    
    /*
     * sort start time and end time together
     * then +1 when counter start, -1 when counter end
     * this cnt means how many meeting are happening right now
     * start: new meeting start, need a new room
     * end: a meeting ends, release one room
     */
    public static int countOfAirplanes3(List<Interval> intervals) {
    	List<Point> points = new ArrayList<>();
    	for(Interval interval : intervals){
    		points.add(new Point(interval.start, 1));
    		points.add(new Point(interval.end, -1));
    	}
    	
    	Collections.sort(points, new Comparator<Point>(){
    		public int compare(Point p1, Point p2){
    			if(p1.x == p2.x) return (int)(p1.y - p2.y);
    			else return (int)(p1.x - p2.x);
    		}
    	});
    	
    	int cnt = 0;
    	int max = 0;
    	for(Point point : points){
    		cnt += point.y;
    		max = Math.max(max, cnt);
    	}
    	return max;
    } 
    
    /*
     * return the maximum overlap interval, with the last one
     * only return 1 overlap
     */
    public static Interval countOfAirplanes4(List<Interval> intervals) {
    	List<Point> points = new ArrayList<>();
    	for(Interval interval : intervals){
    		points.add(new Point(interval.start, 1));
    		points.add(new Point(interval.end, -1));
    	}
    	
    	Collections.sort(points, new Comparator<Point>(){
    		public int compare(Point p1, Point p2){
    			if(p1.x == p2.x) return (int)(p1.y - p2.y);
    			else return (int)(p1.x - p2.x);
    		}
    	});
    	
    	int cnt = 0;
    	int max = 0;
    	int start = 0;
    	Interval interval = new Interval(0,0);
    	for(Point point : points){
    		if(point.y == 1){
    			cnt++;
    			start = (int)point.x;
    		}else if(point.y == -1){
    			if(cnt == max){
    				interval = new Interval(start, (int)point.x);
    			}
    			cnt--;
    		}
    		max = Math.max(max, cnt);
    	}
    	return interval;
    } 

    /*
     * return many interval with maximum overlap
     */
    public static List<Interval> countOfAirplanes5(List<Interval> intervals) {
    	List<Point> points = new ArrayList<>();
    	for(Interval interval : intervals){
    		points.add(new Point(interval.start, 1));
    		points.add(new Point(interval.end, -1));
    	}
    	
    	Collections.sort(points, new Comparator<Point>(){
    		public int compare(Point p1, Point p2){
    			if(p1.x == p2.x) return (int)(p1.y - p2.y);
    			else return (int)(p1.x - p2.x);
    		}
    	});
    	
    	int cnt = 0;
    	int max = 0;
    	int start = 0;
    	for(Point point : points){
    		cnt += point.y;
    		max = Math.max(max, cnt);
    	}
    	System.out.println(max);
    	List<Interval> overlaps = new ArrayList<>();
    	for(Point point : points){
    		if(point.y == 1){
    			cnt++;
    			start = (int)point.x;
    		}else if(point.y == -1){
    			if(cnt == max){
    				overlaps.add(new Interval(start, (int)point.x));
    			}
    			cnt--;
    		}
    		max = Math.max(max, cnt);
    	}
    	return overlaps;
    } 
    
    
    
	public static void main(String[] args){
		int[][] intervals = {{1,10}, {2,3}, {5,8}, {4,7}, {7, 8}};
		List<Interval> airplanes = new ArrayList<Interval>();
		for(int[] interval : intervals){
			airplanes.add(new Interval(interval[0], interval[1]));
		}
		System.out.println(countOfAirplanes2(airplanes));
		System.out.println(countOfAirplanes3(airplanes));
		System.out.println(countOfAirplanes4(airplanes));
		System.out.println(countOfAirplanes5(airplanes));
		System.out.println(countOfAirplanes(airplanes));

	}
}
