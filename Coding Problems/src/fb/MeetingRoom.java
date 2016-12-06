package fb;
import java.util.*;

import leetcode.Interval;

public class MeetingRoom {
	//https://leetcode.com/submissions/detail/75466193/
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
    
    
}
