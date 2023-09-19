class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        for(char x : my_string.toCharArray()){
            int cnt = 0;
            while(cnt != n){
                answer += x;
                cnt++;
            }
        }
        
        return answer;
    }
}