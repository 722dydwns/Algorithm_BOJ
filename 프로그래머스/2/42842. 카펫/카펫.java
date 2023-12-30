import java.util.*;

class Solution {
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        //약수 구하기  
        for(int i=3; i<= sum; i++){
            int j = sum / i; 
            
            if(j >= 3){
                int col = Math.max(i, j);//더 큰값
                int row = Math.min(i, j);//작은 값 
                
                int mid = (col - 2) * (row - 2);
                
                if(mid == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}