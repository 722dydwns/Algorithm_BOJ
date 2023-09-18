class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        if(s1.length >= s2.length) {
            for(String x1 : s1){
                for(String x2 : s2){
                    if(x1.equals(x2)) answer++;
                }
            }
        }else{
            for(String x2 : s2){
                for(String x1 : s1){
                    if(x2.equals(x1)) answer++;
                }
            }
        }
        return answer;
    }
}