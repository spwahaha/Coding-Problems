package google;
import java.util.*;

public class MovingAverageFromDataStream {
    /** Initialize your data structure here. */
    double sum = 0;
    Queue<Integer> q = new LinkedList<>();
    int maxSize = 0;
    public MovingAverageFromDataStream(int size) {
        maxSize = size;
    }
    
    public double next(int val) {
        if(q.size() == maxSize){
            sum -= q.poll();
        }
        q.add(val);
        sum += val;
        return sum / q.size();
    }
}
