package fb;

public class AddandSearchWord {
    class TrieNode {
	    // Initialize your data structure here.
	    char c;
	    TrieNode[] children;
	    boolean isWord;
	    public TrieNode() {
	        c = ' ';
	        children = new TrieNode[26];
	        isWord = false;
	    }
	    
	    public TrieNode(char c){
	        this.c = c;
	        children = new TrieNode[26];
	        isWord = false;
	    }
	}
	
	TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(word, root);
    }
    
    private boolean search(String word, TrieNode root){
        if(word.length() == 0) return true;
        if(root == null) return false;
        if(word.length() == 1){
            char c = word.charAt(0);
            if(c != '.'){
                return root.children[c - 'a'] != null && root.children[c - 'a'].isWord;
            }else{
                for(int i = 0; i < root.children.length; i++){
                    if(root.children[i] != null && root.children[i].isWord) return true;
                }
                return false;
            }
        }
        
        char c = word.charAt(0);
        if(c != '.'){
            TrieNode node = root.children[c - 'a'];
            if(node == null) return false;
            return search(word.substring(1), node);
        }else{
            for(int i = 0; i < root.children.length; i++){
                if(search(word.substring(1), root.children[i])) return true;
            }
            return false;
        }
        
    }
    
    public static void main(String[] args){
    	AddandSearchWord dic = new AddandSearchWord();
    	dic.addWord("bad");
    	dic.addWord("dad");
    	dic.addWord("mad");
    	System.out.println(dic.search("pad"));
    	System.out.println(dic.search("bad"));
    	System.out.println(dic.search(".ad"));
    	System.out.println(dic.search("b.."));
    }
}
