class Solution {
    public int solution(int[] num_list) {
        
        String a = "";
        String b = "";
        
        for(int x : num_list){
            if(x % 2 == 0){
                //짝수
                a += String.valueOf(x);
            }else{
                //홀수
                b += String.valueOf(x);
            }
        }
        
        int answer = Integer.parseInt(a) + Integer.parseInt(b);
        
        
        return answer;
    }
}