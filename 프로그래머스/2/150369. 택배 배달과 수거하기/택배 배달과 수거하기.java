class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d_cap = 0;
        int p_cap = 0;
        
        for(int i=n-1; i>=0; i--){ //역순 탐색
            d_cap += deliveries[i];
            p_cap += pickups[i];
            
            while(d_cap > 0 || p_cap >0) {
                //둘 중 하나라도 0보다 크다면 
                // cap 빼줌 : 왜 ? - 현재 i+1 지점에서 차가 접근해서 처리한 거임 
                //cap 빼주고 음수가 됐다면 물류 안들려도 되는 거고 
                //cap 빼주고 양수가 됐다면 물류창고 한번 더 가야 하는거임
                d_cap -= cap;
                p_cap -= cap;
                answer += (i+1) * 2;
            }
        }
        
        return answer;
    }
}