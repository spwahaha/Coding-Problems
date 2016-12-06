package google;
import java.util.*;

public class VerifyPreorderSerializationOfABinaryTree {
    //https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/
	public boolean isValidSerialization(String preorder) {
        if(preorder == null) return false;
        Stack<String> stack = new Stack<>();
        String[] strs = preorder.split(",");
        for(int i = 0; i < strs.length; i++){
            String cur = strs[i];
            while(cur.equals("#") && !stack.isEmpty() && stack.peek().equals(cur)){
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
	
	
    public boolean isValidSerialization2(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node : nodes){
            diff--;
            if(diff < 0) return false;
            if(!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
	
}
