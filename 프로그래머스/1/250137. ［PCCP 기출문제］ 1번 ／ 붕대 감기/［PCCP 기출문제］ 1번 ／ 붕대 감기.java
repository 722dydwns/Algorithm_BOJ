import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int N = attacks.length;
        int maxTime = attacks[N-1][0];//이게 최대 시간임 
        
        int T = bandage[0]; //연속 시전
        int X = bandage[1]; //시간당 ++
        int Y = bandage[2]; //연속T 보너스 ++ 
        
        int cur = health;
        int linked = 0;//연속
        //공격성을 전체 시간 배열에 담아둠
        int[] attVal = new int[maxTime + 1]; 
        
        for(int[] x : attacks){
            attVal[x[0]] = x[1]; //공격성 없으면 0일 거임
        }
        
        for(int t = 1; t <=maxTime; t++){
            linked++;  
            //공격성 처리 
            if(attVal[t] > 0) { //공격 바등면 
                linked = 0;//초기화
                cur -= attVal[t];
                if(cur <= 0) return -1;
                continue;
            }

            cur += X;
            if(cur > health) {
                cur = health;//정정해줌
                continue;
            }
            if(linked == T) {
                linked = 0;
                cur += Y;//보너스 처리받고
            }
        }

        return cur;
    }
}