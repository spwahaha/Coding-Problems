package google;
import java.util.*;

public class GroupShiftedStrings {
	//https://leetcode.com/problems/group-shifted-strings/
    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings){
            String key = getKey(str);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                map.put(key, new ArrayList<String>());
                map.get(key).add(str);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
    
    private static String getKey(String str){
        char[] ar = new char[str.length()];
        char first = str.charAt(0);
        ar[0] = 'a';
        for(int i = 1; i < str.length(); i++){
            char c = str.charAt(i);
            ar[i] = (char)(c - first >= 0 ? c - first : c - first + 26);
            ar[i] += 'a';
        }
        return new String(ar);
    }
    
    public static void main(String[] args){
    	System.out.println(groupStrings(new String[]
    			{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }
}
