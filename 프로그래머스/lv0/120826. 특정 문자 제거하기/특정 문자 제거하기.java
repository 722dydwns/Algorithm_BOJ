class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(char x : my_string.toCharArray()){
            if(x == letter.charAt(0)){
                continue;
            }
            answer += x;
        }
        return answer;
    }
}