import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    //DFS
    static void DFS(int lv, int k, int[][] dungeons){
        
        for(int i=0; i<dungeons.length; i++){
            //방문X && 최소 피로도가 k보다 작거나 같은 곳으로는 더 깊이 탐색 가능
            if(!visited[i] && k >= dungeons[i][0]){
                visited[i] = true;
                //더 깊이 레벨탐색, k-소모피로도 보내면서 점차 깊이
                DFS(lv+1, k - dungeons[i][1], dungeons);
                visited[i] = false;//복귀 시 false주기 (다른 뿌리에서도 완탐 해야 함)
            }
        }
        
        answer = Math.max(answer, lv);
        
    }
    //솔루션
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        
        DFS(0, k, dungeons);
        
        return answer;
    }
}