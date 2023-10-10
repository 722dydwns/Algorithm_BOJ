import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] names) {
        ArrayList<String> answer = new ArrayList<>();
        
        answer.add(names[0]);
        int i=0;
        for(String x : names){
            if(i==5){
                i=0;
                answer.add(x);
            }
            i++;
        }
        
       
        return answer;
    }
}