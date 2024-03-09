import java.util.*;
class Solution {
    private static char[][] board;
    private static int N, M;
    private static boolean[][] visited;
    //4방향
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    
    //BFS
    private int BFS(int x, int y){
        Queue<int []> Q= new LinkedList<>();
        visited[x][y] = true;
        Q.offer(new int[] {x, y});
        int answer = Character.getNumericValue(board[x][y]);
        
        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            for(int k=0; k<4; k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || ny <0 || nx >=N || ny>= M || board[nx][ny] == 'X') continue;
                if(visited[nx][ny] == true) continue;
                
                answer += board[nx][ny] - '0';
                visited[nx][ny] = true;
                Q.offer(new int[] {nx, ny});
            }
        }
        return answer;
    }
    
    //솔루션 함수 
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        N = maps.length;
        M = maps[0].length();
        
        board = new char[N][M];
        visited = new boolean[N][M];
        
        boolean flag = false;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j] = maps[i].charAt(j);
                if(board[i][j] != 'X') flag = true;
            }
        }
        
        if(!flag) {
            answer.add(-1);
            return answer;
        } 
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && board[i][j] != 'X'){
                    answer.add(BFS(i, j));
                }
            }
        }
        
        Collections.sort(answer);
        
        return answer;
    }
}