package snapchat;
import java.util.*;
import java.util.Map.Entry;

public class MeetingRoomSchedule {
	public static class Interval{
		int start;
		int end;
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		public String toString(){
			return "[" + this.start + "," + this.end + "]";
		}
	}
	
	public static List<String> meetingRoomSchedule(Interval[] intervals){
		List<String> res = new ArrayList<>();
		if(intervals == null || intervals.length == 0) return res;
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
		TreeMap<Interval, List<Interval>> map = new TreeMap<Interval, List<Interval>>(new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});
		map.put(intervals[0], new ArrayList<>());
		map.get(intervals[0]).add(new Interval(intervals[0].start, intervals[0].end));
		for(int i = 1; i < intervals.length; i++){
			Interval interval = pq.poll();
			if(interval.end <= intervals[i].start){
				map.get(interval).add(new Interval(intervals[i].start, intervals[i].end));
				interval.end = Math.max(interval.end, intervals[i].end);
			}else{
				map.put(intervals[i], new ArrayList<>());
				map.get(intervals[i]).add(new Interval(intervals[i].start, intervals[i].end));
				pq.add(intervals[i]);
			}
			pq.add(interval);
		}
		
		while(map.size() > 0){
			Entry<Interval, List<Interval>> entry = map.pollFirstEntry();
			List<Interval> list = entry.getValue();
			StringBuilder sb = new StringBuilder();
			for(Interval inter : list){
				sb.append(inter.toString() + ",");
			}
			res.add(sb.substring(0, sb.length() - 1).toString() + "\n");
		}		
		return res;
	}
	
	public static void main(String[] args){
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(3, 6);
		intervals[1] = new Interval(6, 9);
		intervals[2] = new Interval(5, 7);
		
		System.out.println(meetingRoomSchedule(intervals));
	}
}
