package fb;

public class AddBinary {
	//https://leetcode.com/problems/add-binary/
	/*
	 * from the end to start, like the math add calculation
	 */
    public static String addBinary(String a, String b) {
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
        	carry = sum / 2;
        	sum = sum % 2;
        	sb.append(sum);
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
    public static void main(String[] args){
    	System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("11", "1"));
    }
}
