package google;

public class StrobogrammaticNumber {
	//https://leetcode.com/problems/strobogrammatic-number/
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return true;
        int l = 0;
        int r = num.length() - 1;
        while(l <= r){
            int n1 = num.charAt(l++) - '0';
            int n2 = num.charAt(r--) - '0';
            if(!Strobo(n1, n2)) return false;
        }
        return true;
    }
    
    private boolean Strobo(int n1, int n2){
        if(n1 == n2 && n1 == 0) return true;
        if(n1 == n2 && n1 == 1) return true;
        if(n1 == n2 && n1 == 8) return true;
        if(n1 == 6 && n2 == 9) return true;
        if(n1 == 9 && n2 == 6) return true;
        return false;
    }
    
    public boolean isStrobogrammatic2(String num) {
        if(num == null || num.length() == 0) return true;
        for(int i = 0, j = num.length() - 1; i <= j; i++, j--){
            if(!("00 11 88 696").contains("" + num.charAt(i) + num.charAt(j))) return false;
        }
        return true;
    }
}
