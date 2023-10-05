import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] arr, int n) {
        //answer 
        ArrayList<Integer> answer = new ArrayList<>();
        int len = arr.length;
        
        if(len % 2 == 0){ //길이 짝수인 경우 
            for(int i=0; i<len; i++){ 
                if(i%2!=0){//홀수 인덱스값에는 n더해서 
                    answer.add(arr[i] + n);
                }else{
                    answer.add(arr[i]);
                }
            }
        }else{ //길이 홀수인 경우 
            for(int i=0; i<len; i++){
                if(i % 2 == 0){
                    //짝수 인덱스값에 n더해서 
                    answer.add(arr[i] + n);
                }else{
                    answer.add(arr[i]);
                }
            }
        }
        
        return answer;
    }
}