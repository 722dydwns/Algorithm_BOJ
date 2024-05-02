import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        List<String> num = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
        
        for(int i=0; i<num.size(); i++){
            s = s.replaceAll(num.get(i), String.valueOf(i));
        }
        
        answer = Integer.parseInt(s);
        return answer;
    }
}