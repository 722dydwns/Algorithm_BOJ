import java.util.*;

class Solution{
    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        
        if(s.length() == 0){
            return 0;
        }
        
        stack.push(s.charAt(idx++));
        
        while(idx<s.length()){
            char c = s.charAt(idx++);
            
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer= 0;
        }
        

        
        return answer;
    }
}