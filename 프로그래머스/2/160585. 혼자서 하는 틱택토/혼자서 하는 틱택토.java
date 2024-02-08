import java.util.*;

class Solution {
    static char[][] map;
    //O 빙고 판별
    static boolean isBingGo(char c){ //현재값을 담으면 빙고 되는지 여부 판별 
        for(int i=0; i<3; i++){ 
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) return true;//행 빙고
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) return true;//열 빙고 
        }
        //대각선 빙고
        if(map[1][1] == c){
            if(map[0][0] == c && map[2][2] == c) return true;
            if(map[0][2] == c&& map[2][0] == c) return true;
        }
        return false;
    }
   
    
    //솔루션 함수 
    public int solution(String[] board) {
        int Ocnt = 0;
        int Xcnt = 0;
        map = new char[3][3];
        
        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                char tmp = board[i].charAt(j);
                if(tmp == 'O') Ocnt++;
                if(tmp == 'X') Xcnt++;
                map[i][j] = tmp;
            }
        }
        //X 개수가 더 클 경우는 애초에 안됨 
        if(Xcnt > Ocnt) return 0;
        //O가 빙고인데 X개수가 크거나 같은 건 말도 안됨 
        if(isBingGo('O') && Ocnt - Xcnt != 1) return 0;
        //X가 (후공) 먼저 빙고 칠 경우, 둘 크기는 같아야 됨. O가 클 수 없음  말이 안됨 
        if(isBingGo('X') && Ocnt - Xcnt != 0) return 0;
        // O의 개수도 X개수보다 2개 이상일 수는 없음 최대 1개 차이만 나야 함 
        if(Ocnt - Xcnt >= 2) return 0;
        
        return 1;
    }
}