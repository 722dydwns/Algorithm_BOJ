class Solution {
    public int solution(int a, int b) {
        
        String A = "";//A먼저 
     
        String B = "";//B먼저 
        
        A += String.valueOf(a) + String.valueOf(b);
        B += String.valueOf(b) + String.valueOf(a);
        
        a = Integer.parseInt(A);
        b = Integer.parseInt(B);
        
        int answer = Math.max(a, b);
        return answer;
    }
}