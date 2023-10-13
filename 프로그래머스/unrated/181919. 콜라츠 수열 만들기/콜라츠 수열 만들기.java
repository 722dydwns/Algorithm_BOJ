import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        while(n != 1){
            answer.add(n);
            if(n % 2 == 0){
                //짝수이면 
                n /= 2;
            }else{
                //홀수이면 
                n = (n * 3) + 1;
            }
        }
        answer.add(1);
        
        return answer;
    }
}