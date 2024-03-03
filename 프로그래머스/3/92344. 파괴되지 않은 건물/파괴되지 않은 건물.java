import java.util.*;
class Solution {
    //솔루션 함수 
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        //1) 누적합 구할 용도 2차원 배열 선언 공간 1씩 크게 선언해야 됨 
        int[][] sums = new int[N+1][M+1]; 
        
        //2) 각 경계에 처리해줘야 할 경계 포인터 찍어주기 
        for(int[] sk : skill){
            int val = sk[5];
            if(sk[0] == 1) {
                val = -sk[5];
            }
            
            int sx = sk[1];
            int sy = sk[2];
            int ex = sk[3];
            int ey = sk[4];
            
            //경계 포인터 누적 찍기
            sums[sx][sy] += val;
            sums[sx][ey+1] += (-val);// 반대로 (경계 처리)
            sums[ex+1][sy] += (-val);// 반대로 (경계 처리)
            sums[ex+1][ey+1] += val;
        }
        
        //3) 각 경계에 있는 거 행별/열별 누적 처리 
        for(int i=0; i<=N; i++){
            for(int j=1; j<=M; j++){//열 기준 직전과 현재값을 누적합
                sums[i][j] += sums[i][j-1];
            }
        }
        
        for(int j=0; j<=M; j++){
            for(int i=1; i<=N; i++){ //행 기준 직전과 현재값을 누적합 
                sums[i][j] += sums[i-1][j]; 
            }
        }
        
        int answer = 0;
        //4) board에 각 경계별 처리된 sums의 누적된 값들만 처리해주기 
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] += sums[i][j];
                if(board[i][j] >= 1) answer++;
            }
        }
        return answer;
    }
}