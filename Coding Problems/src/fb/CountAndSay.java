package fb;

public class CountAndSay {
	//https://leetcode.com/problems/count-and-say/
    public static String countAndSay(int n) {
        if(n <= 0) return "";
        String s = "1";
        for(int i = 2; i <= n; i++){
            int cnt = 0;
            char c = s.charAt(0);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == c){
                    cnt++;
                }else{
                    sb.append(cnt + "" + c);
                    c = s.charAt(j);
                    cnt = 1;
                }
            }
            sb.append(cnt + "" +  c);
            s = sb.toString();
        }
        return s;
    }
    
    public static void main(String[] arg) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
