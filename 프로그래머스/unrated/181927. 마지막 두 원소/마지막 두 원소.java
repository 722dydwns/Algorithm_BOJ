import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] num_list) {
        int len = num_list.length;
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<len; i++){ //마지막 제외하고 담아두고 
            answer.add(num_list[i]);
        }
        
        if(num_list[len-1] <= num_list[len-2]) {
            //마지막 원소가 그 앞 원소보다 크지 않다면. 
            answer.add(num_list[len-1] * 2);//기존의 마지막 원소를 2배한 값을 담는다.
        }else{
            answer.add(num_list[len-1] - num_list[len-2]);
        }
       
            
        
        return answer;
    }
}