package google;

public class DecodeString {
	//https://leetcode.com/problems/decode-string/
    public static String decodeString(String s) {
        if(s == null || s.length() < 2) return s;
        int[] i = new int[1];
        return decode(s, i);
    }
    
    private static String decode(String str, int[] i){
        StringBuilder sb = new StringBuilder();
        while(i[0] < str.length() && str.charAt(i[0]) != ']'){
            char c = str.charAt(i[0]);
            if(c >= '0' && c <= '9'){
                int num = 0;
                while(str.charAt(i[0]) != '['){
                    num = num * 10 + str.charAt(i[0]) - '0';
                    i[0]++;
                }
                i[0]++;
                String s = decode(str, i);
                i[0]++;
                while(num-- > 0){
                    sb.append(s);
                }
            }else{
                sb.append(c);
                i[0]++;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(decodeString("3[a]2[bc]"));
    }
}
