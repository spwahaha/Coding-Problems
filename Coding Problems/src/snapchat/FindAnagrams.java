package snapchat;
import java.util.*;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] cnt = new int[256];
        for(int i = 0; i < p.length(); i++){
            cnt[p.charAt(i)]++;
        }
        List<Integer> res = new ArrayList<>();
        int found = 0;
        int l = 0; int r = 0;
        while(r < s.length()){
            if(cnt[s.charAt(r)] > 0){
                found++;
            }
            cnt[s.charAt(r++)]--;
            
            if(found == p.length()){
                res.add(l);
            }
            if(r - l == p.length()){
                if(cnt[s.charAt(l)] >= 0){
                    found--;
                }
                cnt[s.charAt(l++)]++;
            }
        }
        return res;
    }
}
