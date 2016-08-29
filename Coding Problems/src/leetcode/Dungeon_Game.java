package leetcode;

public class Dungeon_Game {
	//https://leetcode.com/problems/dungeon-game/
    public static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 1;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] blood = new int[m + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            blood[m][i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < m + 1; i++){
            blood[i][n] = Integer.MAX_VALUE;
        }
        blood[m - 1][n] = 1;
        blood[m][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                blood[i][j] = Math.min(blood[i][j + 1], blood[i + 1][j]) - dungeon[i][j];
                blood[i][j] = Math.max(1, blood[i][j]);
            }
        }
        return blood[0][0];
    }
    
    public static int calculateMinimumHP2(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 1;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] blood = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            blood[i] = Integer.MAX_VALUE;
        }
        blood[n] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                blood[j] = Math.min(blood[j + 1], blood[j]) - dungeon[i][j];
                blood[j] = Math.max(1, blood[j]);
                blood[n] = Integer.MAX_VALUE;
            }
        }
        return blood[0]; 
    }

    public static int calculateMinimumHP3(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0) return 1;
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] blood = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            blood[i] = Integer.MAX_VALUE;
        }
        blood[n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                blood[j] = Math.min(blood[j + 1], blood[j]) - dungeon[i][j];
                blood[j] = Math.max(1, blood[j]);
            }
        }
        return blood[0]; 
    }
    
    public static void main(String[] args){
    	int[][] nums = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
    	System.out.println(calculateMinimumHP(nums));
    	System.out.println(calculateMinimumHP2(nums));
    	System.out.println(calculateMinimumHP3(nums));
    }
}
