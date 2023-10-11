import java.util.*;
class Solution {
    public int solution(String number) {
        int tmp = 0;
        for(char x : number.toCharArray()){
            tmp += Character.getNumericValue(x);
            //각 자릿수의 합 
        }
        
        int answer = tmp % 9;
       
        return answer;
    }
}