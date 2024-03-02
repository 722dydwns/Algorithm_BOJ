import java.util.*;
class Solution {
    //솔루션 함수 
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        //누적합용 
        int[][] sums = new int[N+1][M+1];
        
        for(int[] sk : skill){
            int val = sk[0] == 1 ? -sk[5] : sk[5];
            int sx = sk[1];
            int sy = sk[2];
            int ex = sk[3];
            int ey = sk[4];
            
            //영역별 구간합 둘 좌표 찍어두기 
            sums[sx][sy] += val;
            sums[sx][ey+1] -= val;
            sums[ex+1][sy] -= val;
            sums[ex+1][ey+1] += val;
        }
        
        //누적합
        for(int j = 0; j<M; ++j){
            for(int i=1; i<N; ++i){
                sums[i][j] += sums[i-1][j]; //행 기준 직전합에 누적합
            }
        }
        
        for(int i=0; i<N; ++i){
            for(int j=1; j<M; ++j){
                sums[i][j] += sums[i][j-1]; //열 기준 직전열에 누적합
            }
        }
        
        //누적된 sums값을 board에 합체시키기 
        int answer = 0;
        
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                board[i][j] += sums[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}