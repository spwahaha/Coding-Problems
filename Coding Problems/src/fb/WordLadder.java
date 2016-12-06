package fb;
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null) return 0;
        if(beginWord.equals(endWord)) return 1;
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordList.add(endWord);
        int cnt = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String word = q.poll();
                if(word.equals(endWord)) return cnt;
                addWords(word, q, wordList);
            }
            cnt++;
        }
        return 0;
    }
    
    private void addWords(String word, Queue<String> q, Set<String> wordList){
        char[] w = word.toCharArray();
        for(int i = 0; i < w.length; i++){
            char c = w[i];
            for(char j = 'a'; j <= 'z'; j++){
                w[i] = j;
                String newWord = new String(w);
                if(wordList.contains(newWord)){
                    q.add(newWord);
                    wordList.remove(newWord);
                }
            }
            w[i] = c;
        }
    }
}
