package google;
import java.util.*;

public class EvaluateDivision {
	//https://leetcode.com/problems/evaluate-division/
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> pairMap = new HashMap<>();
        Map<String, ArrayList<Double>> valueMap = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            String start = equations[i][0];
            String end = equations[i][1];
            double val = values[i];
            if(!pairMap.containsKey(start)){
                pairMap.put(start, new ArrayList<String>());
                valueMap.put(start, new ArrayList<Double>());
            }
            if(!pairMap.containsKey(end)){
                pairMap.put(end, new ArrayList<String>());
                valueMap.put(end, new ArrayList<Double>());
            }
            
            pairMap.get(start).add(end);
            pairMap.get(end).add(start);
            valueMap.get(start).add(val);
            valueMap.get(end).add(1/val);
        }
        
        double[] res = new double[queries.length];
        for(int i = 0; i < queries.length; i++){
            String start = queries[i][0];
            String end = queries[i][1];
            res[i] = dfs(start, end, pairMap, valueMap, new HashSet<String>(), 1.0);
            if(res[i] == 0.0) res[i] = -1.0;
        }
        return res;
    }
    
    private double dfs(String start, String end, Map<String, ArrayList<String>> pairMap, Map<String, ArrayList<Double>> valueMap, HashSet<String> set, double value){
        if(set.contains(start)) return 0;
        if(!pairMap.containsKey(start)) return 0;
        if(start.equals(end)) return value;
        
        set.add(start);
        ArrayList<String> pairs = pairMap.get(start);
        ArrayList<Double> values = valueMap.get(start);
        for(int i = 0; i < pairs.size(); i++){
            double res = dfs(pairs.get(i), end, pairMap, valueMap, set, values.get(i) * value);
            if(res != 0.0) return res;
        }
        set.remove(start);
        return 0.0;
    }
}
