package fb;

public class AddString {
    public static String addString(String a, String b) {
    	if(a == null && b == null) return null;
    	if(a == null) return b;
    	if(b == null) return a;
    	StringBuilder sb = new StringBuilder();
    	int i = a.length() - 1;
    	int j = b.length() - 1;
    	int carry = 0;
    	while(i >= 0 || j >= 0){
    		int n1 = i >= 0 ? a.charAt(i--) - '0' : 0;
    		int n2 = j >= 0 ? b.charAt(j--) - '0' : 0;
    		int sum = n1 + n2 + carry;
    		carry = sum / 10;
    		sum = sum % 10;
    		sb.append(sum);
    	}
    	if(carry != 0) sb.append(carry);
    	return sb.reverse().toString();
    }
    
    public static void main(String[] args){
    	System.out.println(addString("123", "123"));
    	System.out.println(addString("123", "999"));
    	System.out.println(addString("10", "90"));
    }
    
}
