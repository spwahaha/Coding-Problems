package fb;

public class PaintHouseII {
	//https://leetcode.com/problems/paint-house-ii/
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int len = costs.length;
        int k = costs[0].length;
        
        int min1 = -1;
        int min2 = -1;
        for(int i = 0; i < len; i++){
            int last1 = min1;
            int last2 = min2;
            min1 = -1;
            min2 = -1;
            for(int j = 0; j < k; j++){
                if(j == last1){
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }else{
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                }
                
                if(min1 < 0 || costs[i][j] < costs[i][min1]){
                    min2 = min1;
                    min1 = j;
                }else if(min2 < 0 || costs[i][j] < costs[i][min2]){
                    min2 = j;
                }
            }
        }
        return costs[len - 1][min1];
    }
    
    
}
