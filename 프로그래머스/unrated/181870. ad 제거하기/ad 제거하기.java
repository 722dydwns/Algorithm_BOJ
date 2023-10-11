import java.util.*;
class Solution {
    public ArrayList<String> solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList<>();
        for(String x : strArr){
           if(x.contains("ad")) continue;
            answer.add(x);
        }
        return answer;
    }
}