import java.util.*;

class Solution {
    static int answer = Integer.MAX_VALUE;
    private static int[][] score = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    //getSum
    private static int getSum(int pick, String mineral){
        int idx = 0;
        if(mineral.equals("diamond")) idx = 0;
        if(mineral.equals("iron")) idx = 1;
        if(mineral.equals("stone")) idx = 2;
        
        return score[pick][idx];
    }
    
    //솔루션 함수 
    public int solution(int[] picks, String[] minerals) {
        
        DFS(picks,minerals,0,0);
        
        return answer;
    }
    
    static void DFS(int[] picks, String[] minerals, int res, int idx){
        boolean flag = true;
        for(int pick : picks){
            if(pick != 0){
                flag = false;
                break;
            }
        }
        
        if(idx >= minerals.length || flag ){
            answer = Math.min(answer,res);
            return;
        } 
        
        int N = idx + 5;
        if(N > minerals.length) N = minerals.length;
        
        for(int i=0;i<picks.length;i++){
            if(picks[i]==0) continue;
            int tmp = 0;
            for(int j=idx; j<N; j++){
                tmp += getSum(i, minerals[j]);
            }
            
            picks[i]--;
            DFS(picks,minerals, res + tmp, N);
            picks[i]++;
        }
    }
}