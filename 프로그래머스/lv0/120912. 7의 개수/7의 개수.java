import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int x : array){
            if(x== 7) answer++;
            else{
                String tmp = String.valueOf(x);
                for(char c : tmp.toCharArray()){
                    if(c == '7') {
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}