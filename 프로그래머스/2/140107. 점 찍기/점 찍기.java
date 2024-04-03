import java.util.*;
class Solution { 

    //getDistance
    public static double getDistance(int x, int y){
        return Math.ceil(Math.sqrt(Math.pow(x,2) + Math.pow(y, 2)));
    }
    
    //솔루션 함수 
    public long solution(int k, int d) {
        long answer = 0;
    
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<=d; i+=k){
            list.add(i);
        }
        
        for(int x : list){
            int maxY = (int) Math.sqrt((long) d * d - (long) x * x);
            answer += (maxY/k + 1);
        }
        
        return answer;
    }
}