package leetcode;

import java.util.Stack;

public class Simplify_Path {
	//https://leetcode.com/problems/simplify-path/
    public static String simplifyPath(String path) {
        if(path == null) return null;
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<String>();
        for(String str : strs){
            if(str.equals("")) continue;
            else if(str.equals(".")) continue;
            else if(str.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else stack.push(str);
        }
        if(stack.isEmpty()) return "/";
        String res = "";
        while(!stack.isEmpty()){
            String str = stack.pop();
            res = "/" + str + res;
        }
        return res;
    }
    
    public static void main(String[] args){
    	System.out.println(simplifyPath("/abc/..."));
    	System.out.println(simplifyPath("/home/"));
    	System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
