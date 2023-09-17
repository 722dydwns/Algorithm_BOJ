class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        //1) 일단 총액 계산 
        answer = n*12000 + k*2000;
        
        //2) n > 10 이상이면 n /10 몫 만큼 총액 - 음료*몫 해서 받음 
        if(n >= 10){
            answer -= 2000 * (n/10);
        }
        
        return answer;
    }
}