import java.util.*;

class Solution {
   
    public int[] solution(String s) {
        int[] answer = new int[2];
        int total_repeat = 0;
        int total_remove_zero = 0;
        
        String str = s;
        
        while(true){
            if(str.equals("1")) break;
            
            total_repeat++;
            int zero_cnt = 0;
            
            String tmp = "";
            
            for(char x : str.toCharArray()){
                if(x == '0') zero_cnt++;
                if(x == '1') tmp += String.valueOf(x);
            }
            
            total_remove_zero += zero_cnt;
            str = Integer.toBinaryString(tmp.length());
        }
        
        answer[0] = total_repeat;
        answer[1] = total_remove_zero;
        
        return answer;
    }
}