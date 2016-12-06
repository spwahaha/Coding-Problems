package google;
import java.util.*;

public class LongestAbsoluteFilePath {
	//https://leetcode.com/problems/longest-absolute-file-path/
    public int lengthLongestPath(String input) {
        if(input == null | input.length() == 0) return 0;
        String[] strs = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for(String str : strs){
            int level = str.lastIndexOf("\t") + 1;
            while(level + 1 < stack.size()) stack.pop();
            int len = stack.peek() + str.length() - level + 1;
            stack.push(len);
            if(str.contains("."))   max = Math.max(max, len - 1);
        }
        return max;
    }
}
