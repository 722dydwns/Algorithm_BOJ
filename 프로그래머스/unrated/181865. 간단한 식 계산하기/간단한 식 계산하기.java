import java.util.*;
class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] tmp = binomial.split(" ");
        String str = tmp[1];
        if(str.equals("+")){//덧셈
            answer = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]);
        }else if(str.equals("-")){ //뺄셈
            answer = Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]);
        }else if(str.equals("*")){ //곱셈
            answer = Integer.parseInt(tmp[0]) * Integer.parseInt(tmp[2]);
        }
        
        return answer;
    }
}