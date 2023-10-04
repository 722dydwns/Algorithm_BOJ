import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(char x : my_string.toCharArray()){
            if(Character.isUpperCase(x)){
                //대문자인 경우 
                answer += String.valueOf(x).toLowerCase();
            }else {
                //소문자일 경우 
                answer += String.valueOf(x).toUpperCase();
            }
        }
        
        return answer;
    }
}