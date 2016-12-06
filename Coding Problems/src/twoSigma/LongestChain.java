package twoSigma;

import java.util.*;

public class LongestChain {
	public static int longestChain(String[] words){
		if(words == null || words.length == 0) return 0;
		int res = 0;
		Set<String> set = new HashSet<>();
		for(String word : words) set.add(word);
		Map<String, Integer> map = new HashMap<>();
		for(String word : words){
			if(word.length() > res){
				res = Math.max(res, helper(word, set, map));
			}
		}
		return res;
	}
	
	private static int helper(String word, Set<String> set, Map<String, Integer> map){
		int res = 0;
		for(int i = 0; i < word.length(); i++){
			String next = word.substring(0, i) + word.substring(i + 1);
			if(!set.contains(word)) continue;
			if(map.containsKey(next)){
				res = Math.max(res,  map.get(next));
			}else{
				res = Math.max(res,  helper(next, set, map));
			}
		}
		
		map.put(word, res + 1);
		return res;
	}
	
	public static void main(String[] args){
		String[] strs = {"6", "a", "b", "ba", "bca", "bda", "bdca"};
		System.out.println(longestChain(strs));
	}
}
