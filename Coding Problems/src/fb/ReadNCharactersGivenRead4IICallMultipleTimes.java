package fb;

public class ReadNCharactersGivenRead4IICallMultipleTimes {
    //https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int bufferPtr = 0;
    int bufferCnt = 0;
    char[] buffer = new char[4];
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(ptr < n){
            if(bufferPtr == 0){
                bufferCnt = read4(buffer);
            }
            if(bufferCnt == 0) break;
            while(ptr < n && bufferPtr < bufferCnt){
                buf[ptr++] = buffer[bufferPtr++];
            }
            if(bufferPtr == bufferCnt) bufferPtr = 0;
        }
        return ptr;
    }
    
    private int read4(char[] buff){
    	return 1;
    }
    
}
