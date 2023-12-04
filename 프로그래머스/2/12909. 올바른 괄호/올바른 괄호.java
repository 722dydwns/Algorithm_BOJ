import java.util.*;

class Solution {
    //솔루션 함수 
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while(idx < s.length()){
            char c = s.charAt(idx++);
            if(c == '('){
                stack.push(c);
            }else if(c == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}