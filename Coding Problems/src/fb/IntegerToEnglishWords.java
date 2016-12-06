package fb;

public class IntegerToEnglishWords {
	//https://leetcode.com/problems/integer-to-english-words/
    public static String numberToWords(int num) {
        if(num == 0) return "Zero";
        // maxinum: 2147483647
        String[] lessThan20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] thousands = {"", "Thousand", "Million", "Billion"};
        String[] words = new String[4];
        int[] numDigits = new int[4];
        int index = 0;
        while(num > 0){
            numDigits[index++] = num % 1000;
            num /= 1000;
        }
        
        for(int i = 0; i < numDigits.length; i++){
            if(numDigits[i] == 0) continue;
            StringBuilder sb = new StringBuilder();
            int hundred = numDigits[i] / 100;
            if(hundred > 0){
                sb.append(lessThan20[hundred] + " Hundred ");
            }
            numDigits[i] %= 100;
            if(numDigits[i] >= 20){
                int ten = numDigits[i] / 10;
                int ones = numDigits[i] % 10;
                sb.append(tens[ten] + " ");
                if(ones > 0){
                    sb.append(lessThan20[ones]);
                }
            }else{
                sb.append(lessThan20[numDigits[i]]);
            }
            words[i] = sb.toString().trim();
        }
        StringBuilder sb = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--){
            if(words[i] == null) continue;
            sb.append(words[i] + " " + thousands[i] + " ");
        }
        return sb.toString().trim();
    }
    
    public static void main(String[] args){
    	System.out.println(numberToWords(50868));
    	System.out.println(numberToWords(1000));
    	System.out.println(numberToWords(0));
    	System.out.println(numberToWords(10010));
    	System.out.println(numberToWords(999999999));
    }
       
}
