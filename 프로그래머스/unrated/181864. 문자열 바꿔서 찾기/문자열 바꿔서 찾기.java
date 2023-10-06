import java.util.*;
class Solution {
    public int solution(String myString, String pat) {
        String tmp = "";
        for(char x : myString.toCharArray()) {
            if(x == 'A'){
                tmp += "B";
            }else if(x == 'B') {
                tmp += "A";
            }
        }
        
        int answer = 0;
        if(tmp.contains(pat)){
            answer = 1;//담겨있으면 1 
        }
        
        return answer;
    }
}