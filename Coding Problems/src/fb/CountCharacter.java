package fb;

public class CountCharacter {
    
	public static String countCharacter(String s) {
		if(s == null || s.length() == 0) return "";
		StringBuilder sb = new StringBuilder();
		char c = s.charAt(0);
		int cnt = 1;
		for(int i = 1; i < s.length(); i++){
			if(s.charAt(i) == c){
				cnt++;
			}else{
				sb.append(cnt + "" + c);
				cnt = 1;
				c = s.charAt(i);
			}
		}
		sb.append(cnt + "" + c);
		return sb.toString();
    }
	
    public static void main(String[] arg) {
        System.out.println(countCharacter("AABBBCCCD"));
        System.out.println(countCharacter("A"));
        System.out.println(countCharacter(""));
    }

}
