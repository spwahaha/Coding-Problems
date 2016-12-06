package google;
import java.util.*;

public class BinaryWatch {
	//https://leetcode.com/problems/binary-watch/
    public static List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for(int h = 0; h <= 11; h++){
            for(int m = 0; m <= 59; m++){
                if(Integer.bitCount(h * 64 + m) == num){
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(readBinaryWatch(2));
    }
}
