import java.util.*;
class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        for(char x : rsp.toCharArray()){
            if(x == '2') {
                answer += "0";
            }else if(x == '0'){
                answer += "5";
            }else if(x == '5'){
                answer += "2";
            }
        }
        
        return answer;
    }
}