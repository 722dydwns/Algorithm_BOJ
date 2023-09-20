class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        int cnt = 0;
        while(cnt!=k){
            answer += my_string;
            cnt++;
        }
        
        return answer;
    }
}