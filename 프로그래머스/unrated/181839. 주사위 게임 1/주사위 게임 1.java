import java.util.*;
class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        if(a % 2 != 0 && b % 2 != 0){
            //둘다 홀수이면
            answer = (a*a) + (b*b);
        }else if(a % 2 == 0 && b%2!=0 || b % 2 == 0 && a % 2 !=0){
            //둘 중 하나가 홀수 면
            answer = 2 * (a+b);
        }else if(a % 2 ==0 && b % 2 == 0){
            //둘 다 짝수이면 
            answer = Math.abs(a-b);
        }
        
        
        return answer;
    }
}