package snapchat;

public class IPFilter {
	public class TrieNode{
		boolean end;
		TrieNode[] children;
		public TrieNode(){
			this.end = false;
			this.children = new TrieNode[2];
		}
	}
	
	public class Trie{
		TrieNode root = new TrieNode();
		public void insert(String str){
			TrieNode node = root;
			for(int i = 0; i < str.length(); i++){
				int val = str.charAt(i) - '0';
				if(node.children[val] == null){
					node.children[val] = new TrieNode();
				}
				node = node.children[val];
			}
			node.end = true;
		}
		
		private boolean search(String str){
			TrieNode node = root;
			for(int i = 0; i < str.length(); i++){
				int val = str.charAt(i) - '0';
				if(node.children[val] == null) return false;
				node = node.children[val];
				if(node.end) return true;
			}
			return false;
		}
		
	}
	
	
	
	public boolean inTheSameNetwork(String father, String ip){
		if(father == null || ip == null) return false;
		String prefix = getPrefix(father);
		Trie trie = new Trie();
		trie.insert(prefix);
		String ipB = "";
		int index = 0;
		while(index < ip.split("\\.").length){
			ipB += binaryConverter(ip.split("\\.")[index++]);
		}
		return trie.search(ipB);
	}
	
	private String getPrefix(String str){
		String[] twoParts = str.split("/");
		String[] vals = twoParts[0].split("\\.");
		int digitNum = Integer.parseInt(twoParts[1]);
		String prefix = "";
		int index = 0;
		while(prefix.length() < digitNum){
			prefix += binaryConverter(vals[index++]);
		}
		return prefix.substring(0, digitNum);
	}
	
	private String binaryConverter(String val){
		int n = Integer.parseInt(val);
		String res = "";
		for(int i = 0; i < 8; i++){
			res = (n & 1) + res;
			n >>= 1;
		}
		return res;
	}
	
	public static void main(String[] args){
		IPFilter ipFilter = new IPFilter();
		System.out.println(ipFilter.inTheSameNetwork("7.0.0.0/8", "7.0.0.0"));
		System.out.println(ipFilter.inTheSameNetwork("7.0.0.0/8", "8.0.0.0"));
		System.out.println(ipFilter.inTheSameNetwork("7.0.0.0/8", "9.0.0.0"));
	}
}
