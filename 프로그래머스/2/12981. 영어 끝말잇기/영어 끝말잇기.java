import java.util.*;

class Solution {

    //솔루션
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // 무조건 2개임
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<words.length; i++){
            if(i != 0){
                String s1 = words[i-1];//직전 단어
                String s2 = words[i];//현재 단어
                
                char last = s1.charAt(s1.length() -1);//이전 단어의 마지막 철자
                char cur = s2.charAt(0);//현재 단어의 첫 철자
                
                //이미 담긴 단어이거나, 마지막 철자와 현재 철자 다르 경우 
                if(map.containsKey(s2) || last != cur){
                   answer[0] = (i % n) + 1; //얘의 번호 
                   answer[1] = ( i / n) + 1; //회전 횟수
                    
                   return answer;
                }
            }
            
            map.put(words[i], 1);//사용한 단어 맵에 저장함 카운팅 하면서 
        }
        
        return answer;
    }
}