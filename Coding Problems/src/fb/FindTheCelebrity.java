package fb;

public class FindTheCelebrity {
	//https://leetcode.com/problems/find-the-celebrity/
    public int findCelebrity(int n) {
        if(n <= 1) return n;
        int candidate = 0;
        for(int i = 1; i < n; i++){
            // if i doesn't know candidate, candidate can't be celebrity
            // and i might be the celebrity
            if(!knows(i, candidate)){
                candidate = i;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i == candidate) continue;
            if(!knows(i, candidate) || knows(candidate, i)) return -1;
        }
        return candidate;
    }
    
    private boolean knows(int i, int j){
    	return true;
    }
}
