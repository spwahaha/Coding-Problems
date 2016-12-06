package snapchat;

import java.util.HashMap;
import java.util.Map;

public class WordAbbre {
	public class TrieNode{
		char c;
		TrieNode[] chilren;
		int numberOfWord;
		public TrieNode(){
			this.chilren = new TrieNode[26];
			this.numberOfWord = 0;
		}
	}
	
	public void insert(String s, TrieNode root){
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(node.chilren[c - 'a'] == null){
				node.chilren[c - 'a'] = new TrieNode();
			}
			node = node.chilren[c - 'a'];
			node.numberOfWord++;
		}
	}
	
	public String search(String s, TrieNode root){
		TrieNode node = root;
		String prefix = "";
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			node = node.chilren[c - 'a'];
			prefix += c;
			if(node.numberOfWord == 1 && prefix.length() > 1){
				return prefix;
			}
		}
		return prefix;
	}
	
	public String[] encode(String[] strs){
		Map<Integer, TrieNode> wordDic = new HashMap<>();
		for(int i = 0; i < strs.length; i++){
			strs[i] = strs[i].charAt(strs[i].length() - 1) + strs[i];
		}
		String[] res = new String[strs.length];
		
		for(int i = 0; i < strs.length; i++){
			int len = strs[i].length();
			if(!wordDic.containsKey(len)){
				TrieNode root = new TrieNode();
				wordDic.put(len, root);
			}
			insert(strs[i], wordDic.get(len));
		}
		
		for(int i = 0; i < strs.length; i++){
			int len = strs[i].length();
			String prefix = search(strs[i], wordDic.get(len));
			if(prefix.length() + 2 < len){
				res[i] = prefix + "" + (len - 1) + strs[i].charAt(len - 1);
			}else{
				res[i] = strs[i];
			}
			res[i] = res[i].substring(1);
		}
		return res;
	}
	
	
	public static void main(String[] args){
		WordAbbre wa = new WordAbbre();
		String[] strs = {"like", "god", "internal", "me", "internet", "interval", "intension", "face", "intrusion"};
		String[] res = wa.encode(strs);
		for(int i = 0; i < res.length; i++){
			System.out.print(res[i] + ",");
		}
	}
}
