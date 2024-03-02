import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        String alpha = "";
        
        //알파벳 배열 하나 생성하기
        for(char k = 'a'; k<='z'; k++){
            if(skip.contains(Character.toString(k))) continue;
            alpha += k;
        }
        
        //만들기
        for(char x : s.toCharArray()){
            int idx = alpha.indexOf(x);
            //순환 구조 끝단에 만나면 처음을 찍도록 
            int cur = (idx + index) % alpha.length();
            
            //변환된 문자 담기
            answer += alpha.charAt(cur);
        }
        
        
        return answer;
    }
}