package fb;
import java.util.*;

public class RemoveInvalidParentheses {
	
	/*
	 * BFS
	 */
    public static List<String> removeInvalidParentheses(String s) {
        // BFS
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return new ArrayList<String>(Arrays.asList(""));
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        set.add(s);
        boolean found = false;
        while(!q.isEmpty() && !found){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String str = q.poll();
                if(isValid(str)){
                    res.add(str);
                    found = true;
                }
                if(found) continue;
                for(int j = 0; j < str.length(); j++){
                    String str1 = str.substring(0, j);
                    String str2 = str.substring(j + 1, str.length());
                    if(!set.contains(str1 + str2)){
                        q.add(str1 + str2);
                        set.add(str1 + str2);
                    }
                }
            }
        }
        return res;
    }
    
    private static boolean isValid(String s){
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') l++;
            else if(c == ')'){
                if(l == 0) return false;
                l--;
            }
        }
        return l == 0;
    }
    
    public static void main(String[] args){
    	System.out.println(removeInvalidParentheses(")(f"));
    }
}
