import java.util.*;
class Solution {
    public int solution(int[] num_list) {
        int aSum=0;
        int bSum=0;
     
        for(int i=0; i<num_list.length; i++){
            if(i%2 == 0){
                aSum += num_list[i];
            }else{
                bSum += num_list[i];
            }
        }
        
        int answer = Math.max(aSum, bSum);
        return answer;
    }
}