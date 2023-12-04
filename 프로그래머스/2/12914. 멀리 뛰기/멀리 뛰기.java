import java.util.*;
class Solution {
    public long solution(int n) {
        
        long[] dy = new long[2001];
        
        dy[1] = 1;
        dy[2] = 2;
        
        for(int i=3; i<2001; i++){
            dy[i] = (dy[i-2] + dy[i-1]) % 1234567 ;
        }

        return dy[n] ;
    }
}