import java.util.*;

class Solution {
    //솔루션 함수 
    public List<Long> solution(long[] numbers) {
        List<Long> answer = new ArrayList<>();
        
        for(long num : numbers){
            String target = Long.toBinaryString(num);//이진수 변환 
            
            if(num % 2 == 0){ //현재 수가 짝수
                //1더한 값을 변환한 게 정답
                answer.add(num+1);
            }else{ //현재 수가 홀수 
                int idx = target.lastIndexOf("0");
                if(idx == -1){//없다면 맨 앞에 10 붙임
                    String tmp = "10" + target.substring(1, target.length());
                    answer.add(Long.parseLong(tmp, 2)); 
                }else{
                    String tmp = target.substring(0, idx) + "10" + target.substring(idx+2, target.length());
                    answer.add(Long.parseLong(tmp, 2));
                }
                
            }            
        }

        return answer;
    }
}