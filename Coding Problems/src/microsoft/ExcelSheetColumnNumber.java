package microsoft;

public class ExcelSheetColumnNumber {
	//https://leetcode.com/problems/excel-sheet-column-number/
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int val = c - 'A' + 1;
            res = res * 26 + val;
        }
        return res;
    }
}
