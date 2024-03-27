import java.util.*;
class Solution {
    //최대공약수
    static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    //솔루션 함수 
    public long solution(int w, int h) {
       
        long g = gcd((long) Math.max(w, h), (long)Math.min(w, h));
        
        long answer = (long) w * (long) h - (w + h - g);
        
        return answer;
    }
}