package google;
import java.util.*;

public class Flatten2DVector implements Iterator<Integer>{

    Iterator<List<Integer>> it1;
    Iterator<Integer> it2;
    
    public Flatten2DVector(List<List<Integer>> vec2d) {
        it1 = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return it2.next();
    }

    @Override
    public boolean hasNext() {
        while((it2 == null || !it2.hasNext()) && it1.hasNext()){
            it2 = it1.next().iterator();
        }
        return it2 != null && it2.hasNext();
    }
}
