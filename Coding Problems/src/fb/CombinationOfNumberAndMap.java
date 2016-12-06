package fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationOfNumberAndMap {
	/*
	 * Given a string of number and a map, return all possible combination
	 * For example: given 1,2 and a map <<1:'A','B','C'>,<2:'D','E','F'>>
	 * return AD,AE,AF,BD,BE..
	 * 
	 * refer to leetcode: phone number combination
	 */
    public static List<String> getCombinations(int num, Map<Integer, List<Character>> map) {
    	List<String> res = new ArrayList<>();
    	if(num == 0){
    		for(Character c : map.get(0)) res.add(c + "");
    		return res;
    	}
    	res.add("");
    	while(num != 0){
    		int cur = num % 10;
    		num /= 10;
    		List<String> temp = new ArrayList<>();
    		for(int i = 0; i < res.size(); i++){
    			String s = res.get(i);
    			if(!map.containsKey(cur)) continue;
    			for(int j = 0; j < map.get(cur).size(); j++){
    				Character c = map.get(cur).get(j);
    				temp.add(c + s);
    			}
    		}
    		res = temp.size() == 0 ? res : temp;
    	}
    	return res;
    }
    
    public static List<String> getCombinations2(int num, Map<Integer, List<Character>> map) {
    	List<String> res = new ArrayList<>();
    	if(num == 0){
    		for(Character c : map.get(0)) res.add(c + "");
    		return res;
    	}
    	helper(num, map, res);
    	return res;
    }
    
    private static void helper(int num, Map<Integer, List<Character>> map, List<String> res){
    	if(num == 0){
    		res.add("");
    		return;
    	}
    	int cur = num % 10;
    	num /= 10;
    	helper(num, map, res);
    	List<String> temp = new ArrayList<>(res);
    	res.clear();
    	for(String s : temp){
    		for(Character c : map.get(cur)){
    			res.add(s + c);
    		} 
    	}
    	res = temp;
    }


    public static void main(String[] args) {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(1, Arrays.asList('A', 'B', 'C'));
        map.put(2, Arrays.asList('D', 'E', 'F'));
        map.put(0, Arrays.asList('G', 'H'));
        System.out.println(getCombinations(12, map));
        System.out.println(getCombinations(0, map)); 
        System.out.println(getCombinations2(12, map));
        System.out.println(getCombinations2(0, map));
    }
}
