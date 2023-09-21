class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        int size =  my_string.length();
        
        char[] tmp = my_string.toCharArray();
        
        for(int i = size-n; i<size; i++){
            answer += tmp[i];   
        }
        
        return answer;
    }
}