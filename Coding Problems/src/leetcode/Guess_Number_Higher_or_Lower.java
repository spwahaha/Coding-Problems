package leetcode;

public class Guess_Number_Higher_or_Lower {
	private static int TARGET = 6;
    public static int guessNumber(int n) {
    	// correct number is between 1 ~ n, inclusive
        int l = 1;
        int r = n;
        while(l <= r){
            int mid = l + (r - l) / 2;
            int compare = guess(mid);
            if(compare == 0) return mid;
            else if (compare < 0) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
    
    public static int guess(int num){
    	return TARGET - num;
    }
    
    public static void main(String[] args){
    	System.out.println(guessNumber(10));
    }
}
