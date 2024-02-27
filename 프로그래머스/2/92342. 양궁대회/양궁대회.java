import java.util.*;

class Solution {
    private static int[] lion = {-1};
    private static int max = Integer.MIN_VALUE;
    private static int[] res = new int[11];//라이언이 쏜 화살 배열 
    //점수차 구하기 
    private static int score(int[] info){
        int apeach = 0, lion = 0;
        
        for(int i=0; i<res.length; i++){
            if(info[i]==0&&res[i]==0) continue;
            if(info[i]>=res[i]) apeach += (10-i);
            else lion += (10-i );
        }
        int diff = lion - apeach;
        if(diff<=0) return -1;
        return diff;
    }
    
    //DFS 백트래킹
    private static void DFS(int lv, int n, int[] info){
        //깊이 n까지 오면 
        if(lv == n){
            //계산해서 점수 차 
            int diff = score(info);
            if(max <= diff){
                max = diff;
                lion = res.clone();//복사
            }
            return;
        }
        for(int i=0; i<info.length && res[i] <= info[i]; i++){
            res[i]++;
            DFS(lv+1, n, info);
            res[i]--;
        }
        
    }
    
    //솔루션 함수 
    public int[] solution(int n, int[] info) {
        DFS(0, n, info);
        
        if(max == -1){//라이언이 어피치를 못 이길 경우
            lion = new int[1];
            lion[0] = -1;
        }
            
        return lion;
    }
}