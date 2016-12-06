package fb;

public class RemoveListInvalidParantheses {
	public static String removeLeastInvalidParantheses(String str){
		StringBuilder sb = new StringBuilder();
		int left = 0;
		for(int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			if(c == '('){
				left++;
				sb.append('(');
			}else if(c == ')'){
				if(left > 0){
					left--;
					sb.append(')');
				}
			}else sb.append(c);
		}
		
		str = sb.toString();
		String res = "";
		int right = 0;
		for(int i = str.length() - 1; i >= 0; i--){
			char c = str.charAt(i);
			if(c == ')'){
				right++;
				res = ")" + res;
			}else if(c == '('){
				if(right > 0){
					right--;
					res = "(" + res;
				}
			}else{
				res = "" + c + res;
			}
		}
		return res;
	}
	
    public static void main(String[] arg) {
        System.out.println(removeLeastInvalidParantheses("((a)))"));
        System.out.println(removeLeastInvalidParantheses("(((a))"));
        System.out.println(removeLeastInvalidParantheses("())(((a))"));
        System.out.println(removeLeastInvalidParantheses("()((a)))"));
        System.out.println(removeLeastInvalidParantheses("()"));
    }
}
