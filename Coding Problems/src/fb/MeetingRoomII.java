package fb;
import java.util.*;

import leetcode.Interval;

public class MeetingRoomII {
	//https://leetcode.com/problems/meeting-rooms-ii/
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });
        pq.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            Interval curInterval = pq.poll();
            if(curInterval.end <= intervals[i].start){
                //use the same room
                curInterval.end = intervals[i].end;
            }else{
                pq.add(intervals[i]);
            }
            pq.add(curInterval);
        }
        return pq.size();
    }
    
    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int minMeetingRooms2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        List<Point> list = new ArrayList<>();
        for(Interval inter : intervals){
            list.add(new Point(inter.start, 1));
            list.add(new Point(inter.end, -1));
        }
        Collections.sort(list, new Comparator<Point>(){
            public int compare(Point p1, Point p2){
                if(p1.x - p2.x == 0) return p1.y - p2.y;
                else return p1.x - p2.x;
            }
        });
        int cnt = 0;
        int max = 0;
        for(Point p : list){
            cnt += p.y;
            max = Math.max(cnt, max);
        }
        return max;
    }
    
    
}
