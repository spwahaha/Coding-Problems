package google;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
	//https://leetcode.com/problems/encode-and-decode-strings/
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length() + "/" + str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int start = 0;
        while(start < s.length()){
            int slash = s.indexOf('/', start);
            int len = Integer.parseInt(s.substring(start, slash));
            res.add(s.substring(slash + 1, slash + 1 + len));
            start = slash + 1 + len;
        }
        return res;
    }
}
