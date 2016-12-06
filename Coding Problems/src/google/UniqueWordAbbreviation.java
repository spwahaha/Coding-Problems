package google;
import java.util.*;

public class UniqueWordAbbreviation {
    Map<String, Set<String>> map = new HashMap<>();
    public UniqueWordAbbreviation(String[] dictionary) {
        for(String str : dictionary){
            int len = str.length();
            String abbr = (len > 2) ? (""+str.charAt(0) + (len - 2) + str.charAt(len - 1)) : (str);
            if(map.containsKey(abbr)){
                map.get(abbr).add(str);
            }else{
                Set<String> set = new HashSet<>();
                set.add(str);
                map.put(abbr, set);
            }
        }
    }

    public boolean isUnique(String word) {
        int len = word.length();
        String abbr = (len > 2) ? (""+word.charAt(0) + (len - 2) + word.charAt(len - 1)) : (word);
        if(!map.containsKey(abbr)) return true;
        return map.get(abbr).contains(word) && map.get(abbr).size() ==  1;
    }
    
    public static void main(String[] args){
    	UniqueWordAbbreviation uniq = new UniqueWordAbbreviation(new String[]{"dog"});
    	System.out.println(uniq.isUnique("dig"));
    	System.out.println(uniq.isUnique("dug"));
    	System.out.println(uniq.isUnique("dag"));
    	System.out.println(uniq.isUnique("dog"));
    	System.out.println(uniq.isUnique("doge"));
    }
    
}
