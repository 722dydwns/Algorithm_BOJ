import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String myString) {
        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();
       
        for(String x : myString.split("x")){
            answer.add(x.length());
        }
        if(myString.charAt(myString.length()-1) == 'x') answer.add(0);
     
        return answer;
    }
}