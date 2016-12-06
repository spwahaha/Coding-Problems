package snapchat;
import java.util.*;

public class XMLParser {
	public static class XMLNode{
		List<XMLNode> children;
		String content;
		boolean isText;
		public XMLNode(String content){
			this.content = content;
			this.children = new ArrayList<>();
		}
	}
	
	public static class Token{
		String content;
		String type;
		public Token(String content, String type){
			this.content = content;
			this.type = type;
		}
	}
	
	public static XMLNode parseXML(List<Token> tokens){
		if(tokens == null || tokens.size() == 0) return null;
		Stack<XMLNode> stack = new Stack<>();
		XMLNode lastPop = null;
		for(int i = 0; i < tokens.size(); i++){
			Token token = tokens.get(i);
			if(token.type.equals("open")){
				XMLNode node = new XMLNode(token.content);
				if(!stack.isEmpty()){
					stack.peek().children.add(node);
				}
				stack.push(node);
			}else if(token.type.equals("text")){
				XMLNode node = new XMLNode(token.content);
				node.isText = true;
				if(!stack.isEmpty()) stack.peek().children.add(node);
			}else{ // close
				lastPop = stack.pop();
			}
		}
		return lastPop;
	}
	
	public static void main(String[] args){
		List<Token> tokens = new ArrayList<>();
		tokens.add(new Token("html", "open"));
		tokens.add(new Token("user", "open"));
		tokens.add(new Token("id", "open"));
		tokens.add(new Token("aa", "text"));
		tokens.add(new Token("id", "close"));
		tokens.add(new Token("meta", "open"));
		tokens.add(new Token("bb", "text"));
		tokens.add(new Token("meta", "close"));
		tokens.add(new Token("user", "close"));
		tokens.add(new Token("html", "close"));
		parseXML(tokens);
	}
}
