package fb;

public class MultiplyString {

	//https://leetcode.com/problems/multiply-strings/
    public static String multiply(String nums1, String nums2) {
        if(nums1 == null || nums2 == null) return null;
        if(nums1.length() == 0 || nums2.length() == 0) return "";
        int[] res = new int[nums1.length() + nums2.length()];
        for(int i = nums1.length() - 1; i >= 0; i--){
            for(int j = nums2.length() - 1; j >= 0; j--){
                int n1 = nums1.charAt(i) - '0';
                int n2 = nums2.charAt(j) - '0';
                int mul = n1 * n2;
                res[i + j + 1] += mul;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] = res[i + j + 1] % 10;
            }
        }
        int index = 0;
        while(index < res.length){
            if(res[index] != 0) break;
            index++;
        }
        if(index == res.length) return "0";
        StringBuilder sb =  new StringBuilder();
        for(int i = index; i < res.length; i++){
            sb.append(res[i]);
        }
        return sb.toString();
        
    }
    
    
    public String multiply2(String nums1, String nums2) {
        if(nums1 == null || nums2 == null) return null;
        if(nums1.length() == 0 || nums2.length() == 0) return "";
        int[] res = new int[nums1.length() + nums2.length()];
        for(int i = nums1.length() - 1; i >= 0; i--){
            for(int j = nums2.length() - 1; j >= 0; j--){
                res[i + j + 1] += (nums1.charAt(i) - '0') * (nums2.charAt(j) - '0'); 
            }
        }
        int c = 0;
        for(int i = res.length - 1; i >= 0; i--){
            res[i] += c;
            c = res[i] / 10;
            res[i] %= 10;
        }
        int index = 0;
        while(index < res.length){
            if(res[index] != 0) break;
            index++;
        }
        if(index == res.length) return "0";
        StringBuilder sb =  new StringBuilder();
        for(int i = index; i < res.length; i++){
            sb.append(res[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] arg) {
        System.out.println(multiply("9", "9"));
        System.out.println(multiply("0", "123"));
        System.out.println(multiply("1", "123"));
        System.out.println(multiply("22", "123"));
        System.out.println(multiply("34", "123"));
    }
}
