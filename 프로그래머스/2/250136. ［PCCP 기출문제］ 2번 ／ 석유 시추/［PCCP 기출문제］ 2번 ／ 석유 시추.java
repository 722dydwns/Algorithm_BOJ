import java.util.*;

class Solution {
    //4 방향 
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    //visited
    static boolean[][] visited;
    
    //BFS 탐색용 -> 해당 범위 val 반환용 
    static int BFS(int[][] land, int x, int y, int val){
        Queue<int[]> Q = new LinkedList<>();
        visited[x][y] = true;
        Q.offer(new int[] {x, y});
        land[x][y] = val;//세팅 
        int cnt = 1;
        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            for(int k=0; k<4; k++){
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if(nx < 0 || nx >= land.length || ny <0 || ny >= land[0].length || visited[nx][ny] || land[nx][ny] == 0) continue;
                
                //유효하고 1인 값에 대하여 
                visited[nx][ny] = true;
                land[nx][ny] = val;//값 세팅 
                cnt++;
                Q.offer(new int[] {nx, ny});
            }
        }
        
        return cnt;
    }

    //솔루션 함수 
    public int solution(int[][] land) {
  
        visited = new boolean[land.length][land[0].length];
        
        int index = 10; 
        Map<Integer, Integer> map = new HashMap<>();
        
        //1) BFS 전범위 돌면서 1가진 값에 대한 value 얻어오기 
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    int val = BFS(land, i, j, index); //얻은 점수 세팅을 
                    map.put(index, val);//해당 인덱스의 값을 val 로 세팅 
                    index++; //구분하기 위함 
                }
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        //만난 key에 대한 카운팅해서 식별용 
        Map<Integer, Integer> countMap;
        
        
        //각 열에 대한 모든 행에서의 합을 구할 거임 
        for(int i=0; i<land[0].length; i++){ //각 열에 대하여 
            countMap =  new HashMap<>();
            for(int j=0; j<land.length; j++){ //모든 행을 돌거임 
                if(land[j][i] == 0) continue;
                countMap.put(land[j][i], countMap.getOrDefault(land[j][i], 0) + 1);
            }
            
            int sum = 0;
            //탈출 후 
            for(int key : countMap.keySet()){
                sum += map.get(key);
            }
            list.add(sum);
        }
        
        int max = Integer.MIN_VALUE;
        for(int x : list){
            max = Math.max(x, max);
        }
        
        
        return max;
    }
}