package fb;
import java.util.*;

public class AlienDictionary {
	//https://leetcode.com/problems/alien-dictionary/
	public static String alienOrder(String[] words) {
        Map<Character, Integer> degree = new HashMap<Character, Integer>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                degree.put(word.charAt(i), 0);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());
            for(int j = 0; j < len; j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 == c2) continue;
                // c1 -> c2;
                Set<Character> set = map.containsKey(c1) ? map.get(c1) : new HashSet<>();
                if(!set.contains(c2)){
                    set.add(c2);
                    degree.put(c2, degree.get(c2) + 1);
                }
                map.put(c1, set);
                break;
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for(Character c : degree.keySet()){
            if(degree.get(c) == 0) q.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            Character c = q.poll();
            sb.append(c);
            if(map.get(c) == null) continue;
            for(Character ch : map.get(c)){
                degree.put(ch, degree.get(ch) - 1);
                if(degree.get(ch) == 0){
                    q.add(ch);
                }
            }
        }
        if(sb.length() != degree.size()) return "";
        return sb.toString();
    }
	
	public static void main(String[] args){
		System.out.println(alienOrder(new String[]{"za","zb","ca","cb"}));
		
	}
}
