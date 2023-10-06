import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String my_string) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(char x : my_string.toCharArray()){
            if(Character.isAlphabetic(x)) continue;
            answer.add(Character.getNumericValue(x));
        }
        //오름차순 정렬
        Collections.sort(answer);
        
        return answer;
    }
}