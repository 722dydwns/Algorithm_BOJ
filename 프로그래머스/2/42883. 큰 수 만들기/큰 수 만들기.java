import java.util.*;
class Solution {
    //솔루션 함수 
    public String solution(String number, int k) {
       
        StringBuilder sb = new StringBuilder();
        
        int st = 0;
        
        for(int i=0; i<number.length() - k; i++){ //i로 밀고 가는 건 최대 k뺀 값까지 
            char max = '0';
            for(int j=st; j<= i + k; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    st = j + 1;
                }
            }
            //여기서 max값 이어붙임 
            sb.append(max);
        }
        
        return sb.toString();
    }
}