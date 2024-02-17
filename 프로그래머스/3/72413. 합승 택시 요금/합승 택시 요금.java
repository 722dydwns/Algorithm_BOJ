import java.util.*;

class Solution {
    private static int[][] map;
    
    //솔루션 함수 
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        map = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            Arrays.fill(map[i], 1000001);
            map[i][i] = 0;
        }

        for(int[] x : fares){
            int c = x[0];
            int d = x[1];
            map[c][d] = x[2];
            map[d][c] = x[2];
        }
        
        //플로이드
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    
        
        int answer = map[s][a] + map[s][b];
        //경유지점을 다른 지점 하나씩 해보기 
        for(int k=1; k<=n; k++){
            answer = Math.min(answer, map[s][k] + map[k][a] + map[k][b]);
        }
        
        return answer;
    }
}