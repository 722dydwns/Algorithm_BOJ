import java.util.*;

class Solution {
    private static char[][] map;
    //솔루션 함수 
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        map = new char[N][M];
        
        PriorityQueue<int[]> xQ = new PriorityQueue<> ((a, b) -> a[0] - b[0]); //x좌표 최소 우선순위
        PriorityQueue<int[]> yQ = new PriorityQueue<> ((a, b) -> a[1] - b[1]); //y좌표 최소 우선순위 
        PriorityQueue<int[]> xMaxQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> yMaxQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = wallpaper[i].charAt(j);
                if(map[i][j] == '#'){
                    xQ.offer(new int[] {i, j});
                    yQ.offer(new int[] {i, j}); 
                    xMaxQ.offer(new int[] {i, j});
                    yMaxQ.offer(new int[] {i, j});
                }
            }
        }
        
        if(xQ.size() == 1){
            int[] tmp = xQ.poll();
            answer[0] = tmp[0];
            answer[1] = tmp[1];
            answer[2] = tmp[0] + 1;
            answer[3] = tmp[1] + 1;
            
            return answer;
        }
        
        int[] minX = xQ.poll();
        int[] minY = yQ.poll();
        
        answer[0] = minX[0];
        answer[1] = minY[1];
        
        int[] maxX = xMaxQ.poll();
        int[] maxY = yMaxQ.poll();
        
        answer[2] = maxX[0] +  1;
        answer[3] = maxY[1] + 1;
        
        return answer;
    }
}