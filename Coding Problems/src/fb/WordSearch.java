package fb;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false; 
        char[] w = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == w[0]){
                    if(search(board, i, j, w, 0, new boolean[m][n])) return true;
                }
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, int i, int j, char[] word, int start, boolean[][] visited){
        if(start == word.length) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word[start]) return false;
        if(visited[i][j]) return false;
        visited[i][j] = true;
        boolean exist = search(board, i - 1, j, word, start + 1, visited) ||
                        search(board, i + 1, j, word, start + 1, visited) ||
                        search(board, i, j - 1, word, start + 1, visited) ||
                        search(board, i, j + 1, word, start + 1, visited);
        visited[i][j] = false;
        return exist;
    }
}
