package twoSigma;

public class FriendCircle {
	public static int findCircles(String[] friends){
		if(friends == null || friends.length == 0) return 0;
		int cnt = 0;
		int n = friends.length;
		boolean[] visited = new boolean[n];
		for(int i = 0; i < n; i++){
			if(!visited[i]){
				cnt++;
				helper(friends, visited, i);
			}
		}
		return cnt;
	}
	
	private static void helper(String[] friends, boolean[] visited, int pos){
		visited[pos] = true;
		for(int i = 0; i < friends.length; i++){
			if(!visited[i] && friends[pos].charAt(i) == 'Y'){
				helper(friends, visited, i);
			}
		}
	}
	
	public static void main(String[] args){
		String[] friends1 = {"YNYY", "NYYN", "YYYN", "YNNY"};
		String[] friends2 = {"YNNNN", "NYNNN", "NNYNN", "NNNYN", "NNNNY"};
		System.out.println(findCircles(friends1));
		System.out.println(findCircles(friends2));
	}
}
