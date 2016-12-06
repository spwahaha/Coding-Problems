package google;

public class PaintFence {
	//https://leetcode.com/problems/paint-fence/
    public int numWays(int n, int k) {
        if(n <= 0) return 0;
        if(n == 1) return k;
        int sameColor = k;
        int diffColor = k * (k - 1);
        for(int i = 3; i <= n; i++){
            int temp = diffColor;
            diffColor = (sameColor + diffColor) * (k - 1);
            sameColor = temp;
        }
        return sameColor + diffColor;
    }
    
    
}
