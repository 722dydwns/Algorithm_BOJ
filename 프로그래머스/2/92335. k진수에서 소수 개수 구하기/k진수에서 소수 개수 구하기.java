import java.util.*;
class Solution {
    //소수 확인용 
    private boolean isPrime(long val){        
         if(val < 2) return false;
         for(int i=2; i<=(int) Math.sqrt(val); i++){
            if(val % i == 0){
                return false;
            }
        }
        return true;
    }
    //솔루션 함수 
    public int solution(int n, int k) {
        int answer =0;
        
        String val = Integer.toString(n, k);//10진수를 k진수로 변환
        //0기준으로 split 하면 됨
        String[] tmp = val.split("0");
        
        for(String x : tmp){
            if(x.equals("")) continue;
            if(isPrime(Long.parseLong(x))) answer++;
        }
        
        return answer;
    }
}