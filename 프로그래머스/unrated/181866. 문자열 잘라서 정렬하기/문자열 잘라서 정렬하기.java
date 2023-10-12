import java.util.*;

class Solution {
    public ArrayList<String> solution(String myString) {
        ArrayList<String> answer = new ArrayList<>();
        
        String[] tmp = myString.split("x");
       
        for(String str : tmp){
            if(!str.isEmpty()){
                answer.add(str);
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}