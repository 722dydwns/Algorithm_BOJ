import java.util.*;

class Solution {
    static boolean[][] visited;
    //4방향 
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    //BFS
    static int BFS(int x, int y, int[][] maps){
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[] {x, y});
        visited[x][y] = true;
        
        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            if(cur[0] == maps.length-1 && cur[1] == maps[0].length-1) return maps[cur[0]][cur[1]];
            
            for(int k=0; k<4; k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                
                if(nx <0 || ny <0 || nx >= maps.length || ny >= maps[0].length || maps[nx][ny]==0) continue;
                
                if(!visited[nx][ny]) {
                    maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
                    Q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return maps[maps.length-1][maps[0].length -1];
    }
    
    //솔루션
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        
        int answer = BFS(0, 0, maps);
        if(answer == 1){
            return -1;
        }
          
        return answer;
    }
}