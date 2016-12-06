package fb;

public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        boolean end = false;
        int readBytes = 0;
        while(readBytes < n && !end){
            int curRead = read4(buffer);
            if(curRead < 4) end = true;
            int len = Math.min(n - readBytes, curRead);
            for(int i = 0; i < len; i++){
                buf[readBytes+i] = buffer[i];
            }
            readBytes += len;
        }
        return readBytes;
    }
    
    private int read4(char[] buf){
    	return 1;
    }
}
