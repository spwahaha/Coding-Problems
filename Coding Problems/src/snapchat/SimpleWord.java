package snapchat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleWord {
	public String[] simpleWords(String[] words){
		List<String> res = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for(String word : words){
			set.add(word);
		}
		for(String word : words){
			if(word.length() == 0) continue;
			set.remove(word);
			if(!isCompound(word, set)){
				res.add(word);
			}
			set.add(word);
		}
		
		return res.toArray(new String[0]);
	}
	
	private boolean isCompound(String s, Set<String> wordDict){
        if(s == null || s.length() == 0) return false;
        boolean[] canBreak = new boolean[s.length() + 1];
        canBreak[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = i - 1; j >= 0; j--){
                if(wordDict.contains(s.substring(j,i)) && canBreak[j]){
                    canBreak[i] = true;
                }
            }
        }
        return canBreak[s.length()];
	}
	
	public static void main(String[] args){
    	String[] strs = {"chat", "ever",  "snapchat" ,"snap", "salesperson" ,"per", "person", "sales" ,"son" ,"whatsoever" ,"what", "so"};
    	SimpleWord sw = new SimpleWord();
    	String[] res = sw.simpleWords(strs);
    	for(int i = 0; i < res.length; i++){
    		System.out.print(res[i] + ",");
    	}
    	int num = 0;
        num = num << 1;

	}
}
