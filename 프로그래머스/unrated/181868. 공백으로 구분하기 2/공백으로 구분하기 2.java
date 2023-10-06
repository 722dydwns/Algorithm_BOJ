import java.util.*;
class Solution {
    public ArrayList<String> solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        
        for(String x : my_string.split(" ")){
            if(x.equals("")) continue;
            answer.add(x);
        }
        
        return answer;
    }
}