package fb;

public class BalancedParentheses {
	/*
	 * scan from left to right and remove redundant right )
	 * scan from right to left and remove redundant left (
	 */
	public static String balance(String s){
		if(s == null || s.length() == 0) return "";
		char[] chars = s.toCharArray();
		int l = 0;
		int r = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < chars.length; i++){
			char c = chars[i];
			if(chars[i] == '('){
				l++;
				sb.append("(");
			}else{
				if(l > 0){
					l--;
					sb.append(")");
				}
			}
		}
		chars = sb.toString().toCharArray();
		sb = new StringBuilder();
		for(int i = chars.length - 1; i >= 0; i--){
			char c = chars[i];
			if(c == ')'){
				r++;
				sb.append(")");
			}else{
				if(r > 0){
					r--;
					sb.append("(");
				}
			}
		}
		
		return sb.reverse().toString();
	} 
	
	public static void main(String[] args){
        System.out.println(balance("()"));
        System.out.println(balance(")("));
        System.out.println(balance("((((("));
        System.out.println(balance("(()()("));
        System.out.println(balance("(()()("));
        System.out.println(balance(")(())("));	
	}
}
