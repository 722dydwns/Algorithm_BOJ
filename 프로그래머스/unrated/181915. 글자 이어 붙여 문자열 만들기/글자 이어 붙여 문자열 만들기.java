import java.util.*;
class Solution {
    public String solution(String my_string, int[] index_list) {
        
        String answer = "";
        
        char[] tmp = my_string.toCharArray();
        
        for(int x : index_list){
            answer += String.valueOf(tmp[x]);
        }
        
        return answer;
    }
}