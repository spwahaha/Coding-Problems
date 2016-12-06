package microsoft;

public class AddDigits {
	//https://leetcode.com/problems/add-digits/
    public static int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
    
    public static void main(String[] args){
    	for(int i = 10; i < 20; i++){
    		System.out.println(addDigits(i));
    	}
    }
}
