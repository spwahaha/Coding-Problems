package fb;
import java.util.*;

public class TaskSchedule {
	/*
	 * Given a list of task, and a cool down time, which is the minimal 
	 * wait time between two same task
	 * 
	 * return the time needed to finish all the task
	 * 
	 * Use map to store next executable position
	 */
	
	public int taskSchedule(int[] nums, int interval){
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			if(!map.containsKey(nums[i]) || res >= map.get(nums[i])){
				res++;
			}else{
				res = map.get(nums[i]);
			}
			map.put(nums[i], res + interval + 1);
		}
		return res;
	}
	
	
	/*
	 * find the most frequent tasks,
	 * 1. 5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4, fill others in the blank, not enough other tasks
	 *    5 4 3 2 _ 5 4 3 2 _ 5 4 _ _ _ 5 4
	 *    res = (maxCount - 1) * (interval + 1) + maxCount
	 * 2. 5 4 _ _ _ 5 4 _ _ _ 5 4 _ _ _ 5 4, fill others in the blank, enough other tasks
	 * 	  5 4 3 2 1 5 4 3 6 8 5 4 9 7 10 5 4 2, res = nums.length;
	 * 	 */
    public int taskScheduleUnorder(int[] nums, int interval) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int maxFreq = 0;
    	int maxCount = 0;
    	for(int i = 0; i < nums.length; i++){
    		if(!map.containsKey(nums[i])){
    			map.put(nums[i], 1);
    		}else{
    			map.put(nums[i], map.get(nums[i]) + 1);
    		}
    		
    		if(map.get(nums[i]) > maxFreq){
    			maxFreq = map.get(nums[i]);
    			maxCount = 1;
    		}else if(map.get(nums[i]) == maxFreq){
    			maxCount++; 
    		}
    	}
    	
    	return Math.max(nums.length, (maxFreq - 1) * (interval + 1) + maxCount);
    }
    
    public static class Wrapper{
    	char c;
    	int fre;
    	public Wrapper(char c, int fre){
    		this.c = c;
    		this.fre = fre;
    	}
    }
    public static String taskScheduler(String s, int k){
    	if(s == null || s.length() == 0) return "";
    	Map<Character, Integer> map = new HashMap<>();
    	for(int i = 0; i < s.length(); i++){
    		int cnt = map.getOrDefault(s.charAt(i), 0);
    		map.put(s.charAt(i), cnt + 1);
    	}
    	
    	PriorityQueue<Wrapper> pq = new PriorityQueue<>(new Comparator<Wrapper>(){
    		public int compare(Wrapper w1, Wrapper w2){
    			return w2.fre - w1.fre;
    		}
    	});
    	for(Character c : map.keySet()){
    		pq.add(new Wrapper(c, map.get(c)));
    	}
    	int cnt = 0;
    	String res = "";
    	Queue<Wrapper> q = new LinkedList<>();
    	while(cnt < s.length()){
    		if(pq.isEmpty()){
    			res += ",";
    			q.add(new Wrapper(' ', 0));
    		}else{
    			Wrapper wp = pq.poll();
    			res += wp.c;
    			cnt++;
    			wp.fre -= 1;
    			q.add(wp);
    		}
    		if(q.size() > k){
    			Wrapper wp = q.poll();
    			if(wp.fre > 0){
    				pq.add(wp);
    			}
    		}
    	}
    	return res;
    }
    
    

	
	
	
    public static void main(String[] arg) {
    	System.out.println(taskScheduler("bb", 3));
    	System.out.println(taskScheduler("aabbcc", 2));
    	System.out.println(taskScheduler("aabbcc", 3));
    	System.out.println(taskScheduler("aaabc", 2));
    	System.out.println(taskScheduler("aaadbbcc", 1));
    	System.out.println(taskScheduler("aaabc", 3));
    	
    	
        TaskSchedule a = new TaskSchedule();
        System.out.println(a.taskSchedule(new int[]{1}, 1));
        System.out.println(a.taskSchedule(new int[]{1, 1}, 2));
        System.out.println(a.taskSchedule(new int[]{1, 2, 1, 3, 2}, 2));
        System.out.println(a.taskSchedule(new int[]{1, 1, 2, 1}, 2));
        System.out.println(a.taskSchedule(new int[]{1, 2, 3, 1, 2, 3}, 3));

        System.out.println();
        System.out.println(a.taskScheduleUnorder(new int[]{1}, 1));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 1}, 2));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 2, 1, 3, 2}, 2));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 1, 2, 1}, 2));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 2, 3, 1, 2, 3}, 3));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 1, 2, 2, 3, 3}, 3));
        System.out.println(a.taskScheduleUnorder(new int[]{1, 3, 2, 4, 5, 1}, 3));
    }
}
