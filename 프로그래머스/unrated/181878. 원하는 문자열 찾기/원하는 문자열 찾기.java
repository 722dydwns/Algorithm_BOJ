import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        //일단 둘다 대문자로 통일 시켜놓고 
        myString = myString.toUpperCase();
        pat = pat.toUpperCase();
        
        
        int answer = 0;
        if(myString.contains(pat)) {
            //존재한다면 
            answer=  1;
        }
        

        return answer;
    }
}