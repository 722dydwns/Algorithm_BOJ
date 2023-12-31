import java.util.*;

class Solution {
    static boolean[] visited;//방문 1일 1회니까
    static int max = Integer.MIN_VALUE;//최소값 초기화
    //DFS
    static void DFS(int lv, int k, int[][] dungeons){
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){//방문안했고, 해당 던전 최소 피로도보다 k가 클 경우만 
                visited[i] = true;
                DFS(lv+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        max = Math.max(max, lv);
    } 
    
    //솔루션
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visited =new boolean[dungeons.length];//던전 방문 체크용
        
        DFS(0, k, dungeons);
        answer = max;//최대깊이 값 
        
        return answer;
    }
}