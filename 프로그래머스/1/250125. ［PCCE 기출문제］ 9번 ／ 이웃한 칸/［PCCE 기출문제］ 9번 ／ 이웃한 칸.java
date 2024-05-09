import java.util.*;
class Solution {
    //4방향 변수 
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    //솔루션 함수 
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;

        for(int k=0; k<4; k++){
            int nx = h + dx[k];
            int ny = w + dy[k];
            if(nx < 0 || ny < 0 || nx >=n || ny>=n) continue;
            if(board[nx][ny].equals(board[h][w])) answer++;
        }
        
        return answer;
    }
}