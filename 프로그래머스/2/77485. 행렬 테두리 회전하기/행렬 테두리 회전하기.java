import java.util.*;

class Solution {
    private static int[][] map;
    
    //솔루션 함수 
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows+1][columns+1];
        int val = 1;
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = val;
                val++;
            }
        }
        int idx = 0;
        for(int[] x : queries){
            int x1 = x[0];
            int y1 = x[1];
            int x2 = x[2];
            int y2 = x[3];
            
            int tmp = map[x1][y1];//최초값
            int min = tmp;
            
            //오른쪽으로 이동 ->
            for(int i=x1; i<x2; i++){
                map[i][y1] = map[i+1][y1];
                min = Math.min(min, map[i][y1]);
            }
            
            //아래로 이동
            for(int i=y1; i<y2; i++){
                map[x2][i] = map[x2][i+1];
                min = Math.min(min, map[x2][i]);
            }
            
            //왼쪽으로 이동 <-
            for(int i=x2; i>x1; i--){
                map[i][y2] = map[i-1][y2];
                min = Math.min(min, map[i][y2]);
            }
            
            //위로 이동
            for(int i=y2; i>y1; i--){
                map[x1][i] = map[x1][i-1];
                min = Math.min(min, map[x1][i]);
            }
            map[x1][y1+1] = tmp;
            answer[idx] = min;
            idx++;
        }
        
        
        return answer;
    }
}