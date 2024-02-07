import java.util.*;
class Node{
    int x, y, cnt;
    Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}
class Solution{
    //4방향
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    
    //솔루션 함수 
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        int N = board.length;
        int M = board[0].length();
        map = new char[N][M];
        
        int[] st = new int[2];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R'){ // 시작점 세팅 
                    st[0] = i;
                    st[1] = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[N][M];
        visited[st[0]][st[1]] = true;
        
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(st[0], st[1], 0));
        
        while(!Q.isEmpty()){
            Node cur = Q.poll();
            System.out.println(cur.x  + " " + cur.y + " : "+cur.cnt);
            if(answer <= cur.cnt){
                continue;
            }
            if(map[cur.x][cur.y] == 'G'){
                answer = Math.min(answer, cur.cnt);
                continue;
            }
            
            for(int k=0; k<4; k++){
                int nx = cur.x + dx[k];
                int ny = cur.y + dy[k];
                
                if(nx <0 || ny <0 || nx >= N || ny >= M || map[nx][ny] == 'D') continue;
                
                while(nx >=0 && ny >= 0 && nx < N && ny <M && map[nx][ny] != 'D') {
                    nx += dx[k];
                    ny += dy[k];
                }
                
                nx -= dx[k];
                ny -= dy[k];
                
                if(visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                Q.offer(new Node(nx, ny, cur.cnt + 1));
            }
            
        }
        
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}