package google;
import java.util.*;

public class EatingPills {
	
	public static class PillLeft{
		int oneNum;
		int halfNum;
		public PillLeft(int oneNum, int halfNum){
			this.oneNum = oneNum;
			this.halfNum = halfNum;
		}
		
		public boolean equals(PillLeft pl){
			return this.oneNum == pl.oneNum && this.halfNum == pl.halfNum;
		}
	}
	
	public static double possibilityOfOneAndAHalf(){
		Map<PillLeft, Double> map = new HashMap<>();
		return helper(new PillLeft(2, 1), 1, map);
	}
	
	private static double helper(PillLeft left, double posiSofar, Map<PillLeft, Double> map){
		if(left.halfNum == 0 || left.oneNum == 0) return 0;
		if(left.halfNum == 1 && left.oneNum == 1){
			return posiSofar;
		}
		if(map.containsKey(left)) return map.get(left);
		double eatOne = left.oneNum / (double)(left.oneNum + left.halfNum);
		double eatHalf = 1 - eatOne;
		double res = helper(new PillLeft(left.oneNum - 1, left.halfNum + 1), posiSofar * eatOne, map) 
				+ helper(new PillLeft(left.oneNum, left.halfNum - 1), posiSofar * eatHalf, map);
		map.put(left, res);
		return res;
	}
	
	public static void main(String[] args){
		System.out.println(possibilityOfOneAndAHalf());
	}
}
