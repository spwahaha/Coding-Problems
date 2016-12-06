package fb;

import java.util.Arrays;
import java.util.List;

public class CVS {
	/*
	 * List to cvs,
	 * ['ab', 'cd', 'ef'] => ab,cd,ef
	 * ['a,b', 'cd'] => "a,b",cd
	 * ['a"b', 'cd'] => "a""b",cd
	 * if there is ',' in string, add "" to 2 sides
	 * if there is '"' in string, change to two '"' and add "" to 2 sides
	 */
	
	public static String CVStoString(List<String> list){
		StringBuilder resSb = new StringBuilder();
		for(String str : list){
			StringBuilder sb = new StringBuilder("\"");
			boolean special = false;
			for(int i = 0; i < str.length(); i++){
				if(i == 0 || i == str.length() - 1) continue;
				char c = str.charAt(i);
				if(c == ','){
					sb.append(c);
					special = true;
				}else if(c == '"'){
					sb.append(c);
					sb.append(c);
					special = true;
				}else{
					sb.append(c);
				}
			}
			if(special){
				resSb.append(sb.append('"'));
			}else{
				resSb.append(sb.substring(1));
			}
			resSb.append(',');
		}
		return resSb.substring(0, resSb.length() - 1).toString();
	}

    public static void main(String[] arg) {
        System.out.println(CVStoString(Arrays.asList("'ab'", "'ab'", "'ab'")));
        System.out.println(CVStoString(Arrays.asList("'a,b'", "'a\"b'", "'ab'")));
    }
}
