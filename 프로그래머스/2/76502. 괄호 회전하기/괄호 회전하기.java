import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            Stack<Character> stack = new Stack<>();
            //현재 새 str 은 현재 찝은 i ~ 길이 끝까지 뽑고, 그 뒤에 잘린 0, i-1 부분 이어붙임 
            String str = s.substring(i, s.length()) + s.substring(0, i);
            
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(stack.isEmpty()){
                    stack.push(c);
                }else if(c == ')'  && stack.peek() == '('){
                    //짝이 맞으면
                    stack.pop();
                }else if(c == '}' && stack.peek() == '{'){
                    stack.pop();
                }else if(c == ']' && stack.peek() == '['){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            //이 과정 끝난 뒤에 스택 빈상태면 짝이 맞는 경우이므로 
            if(stack.isEmpty()) answer++;
        }
        
        
        return answer;
    }
}