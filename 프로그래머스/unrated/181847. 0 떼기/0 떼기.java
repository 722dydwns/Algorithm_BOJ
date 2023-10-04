import java.util.*;
class Solution {
    public String solution(String n_str) {
        String answer = "";
        int ans = 0;
        for(char x : n_str.toCharArray()){
            ans = (ans * 10)  +   Character.getNumericValue(x);
        }
        answer = String.valueOf(ans);
        
        return answer;
    }
}