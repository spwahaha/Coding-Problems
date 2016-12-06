package google;
import java.util.*;

public class InsertDeleteGetRandomO1 {
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random rand;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        nums = new ArrayList<Integer>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        nums.add(val);
        map.put(val, nums.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int loc = map.get(val);
        if(loc < nums.size() - 1){
            nums.set(loc, nums.get(nums.size() - 1));
            map.put(nums.get(loc), loc);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
