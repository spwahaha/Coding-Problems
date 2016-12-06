package google;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        String sign = (numerator > 0 ^ denominator > 0) ? "-" : "";
        StringBuilder sb = new StringBuilder(sign);
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long inter = num / den;
        sb.append(inter);
        num = num % den;
        if(num == 0){
            return sb.toString();
        }
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        while(num != 0){
            num *= 10;
            sb.append(num / den);
            num %= den;
            if(map.containsKey(num)){
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }else{
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
    	System.out.println(fractionToDecimal(9,11));
    }
}
