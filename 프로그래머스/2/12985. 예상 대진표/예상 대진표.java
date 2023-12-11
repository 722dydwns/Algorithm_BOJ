import java.util.*;

class Solution{
    
    //솔루션 함수 
    public int solution(int n, int a, int b){
        int answer = 0;
        
        while(true){
            a = a /2 + a % 2;//이게 다음 a가 배정받는 번호임
            b = b /2 + b % 2;//다음 b가 배정받는 번호 
            answer++;
            if(a==b) break;
        }

        return answer;
    }
}