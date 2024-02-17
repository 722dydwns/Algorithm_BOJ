import java.util.*;

class Solution {
    private static char[][] map;
    //솔루션 함수 
    public int[] solution(String[] wallpaper) {
        int[] answer;
        
        int N = wallpaper.length;
        int M = wallpaper[0].length();
        
        map = new char[N][M];
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = wallpaper[i].charAt(j);
                if(map[i][j] == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }
    
        return new int[] {minX, minY, maxX, maxY};
    }
}