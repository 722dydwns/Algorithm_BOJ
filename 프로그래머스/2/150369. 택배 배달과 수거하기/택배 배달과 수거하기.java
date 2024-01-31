class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        //트럭 하나로 모든 배달과 수거 마치고 돌아온 (0,0) 최소 이동 거리 return
         long answer = 0; // 거리용 
        
        int d = 0;
        int p = 0;
        for(int i=n-1; i>=0; i--){//뒤부터 돌아야 함 
            d -= deliveries[i]; //배달
            p -= pickups[i]; //수거
            
            while(d <0 || p<0){
                d += cap;
                p += cap;
                answer += (i+1) * 2;
            }
        }
        return answer;
    }
}