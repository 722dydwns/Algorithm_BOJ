class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        for(char x : my_string.toCharArray()){
            if(x == 'a' || x=='e' || x=='i' || x == 'o' || x == 'u') continue;
            else{
                 answer += x;   
            }
        }
        
        return answer;
    }
}