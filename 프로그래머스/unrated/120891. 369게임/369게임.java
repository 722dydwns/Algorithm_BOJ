import java.util.*;
class Solution {
    public int solution(int order) {
        String tmp = String.valueOf(order);
        int answer = 0;
        
        for(char x : tmp.toCharArray()){
            if(x == '3' || x == '6' || x  == '9'){
                answer++;
            }
        }
        
        return answer;
    }
}