class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        int answer = 0;
        
        
        int len1 = arr1.length;
        int len2 = arr2.length;
        
        if(len1 > len2) {
            answer = 1;
        }else if(len2 > len1){
            answer= -1;
        }else if(len1 == len2){
            int ans1 = 0;
            int ans2 = 0;
            for(int i=0; i<len1; i++){
                ans1 += arr1[i];
            }
            for(int i=0; i<len2; i++){
                ans2 += arr2[i];
            }
            
            if(ans1 == ans2) answer = 0;
            else if(ans1 > ans2) {
                answer = 1;
            }else if(ans2 > ans1){
                answer = -1;
            }
        }
        
        
   
        return answer;
    }
}