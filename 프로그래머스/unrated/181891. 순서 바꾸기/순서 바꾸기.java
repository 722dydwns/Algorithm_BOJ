import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] num_list, int n) {
        ArrayList<Integer> answer = new ArrayList<>();
            
        for(int i=0; i<num_list.length; i++){
            if((i+1) < n+1){
               continue;
            }
            answer.add(num_list[i]);
        }
        
        for(int i=0; i<n; i++){
            answer.add(num_list[i]);
        }
            
        return answer;
    }
}