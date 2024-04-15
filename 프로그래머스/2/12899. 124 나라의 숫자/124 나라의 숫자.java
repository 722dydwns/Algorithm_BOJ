import java.util.*;
class Solution {
    //솔루션 함수 
    public String solution(int n) {
        String answer = "";
        
        List<String> nums = Arrays.asList("4", "1", "2");
        
        while(n  > 0){
            answer = nums.get(n%3) + answer;
            n = (n-1) /3;
        }
        
        return answer;
    }
}