class Solution {
    static boolean[][] chk;
    
    public int solution(int n, int[][] results) {
        //선수 1번부터 n번까지라서 
        chk = new boolean[n+1][n+1];
        
        for(int [] x: results){
            int a = x[0];
            int b= x[1];
            //a-> b 순으로 
            chk[a][b] = true;//방문 가능하도록 체킹
        }
        
        //플로이드 시작 
        for(int k=1; k<=n; k++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(chk[i][k] && chk[k][j]){ //k를 경유해서 i->j로 갈 수 있따면 
                        chk[i][j] = true;
                    }
                }
            }
        }
        int[] cnt = new int[n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(chk[i][j] || chk[j][i]) { //i기준으로 진출 진입 차수 누적시켜서 담기 
                    cnt[i]++;
                }
            }
        }

        int answer = 0;
        //이제 cnt[]의 진입+진출이 n-1개인 것 즉, 자기 자신 제외하고 진출하든 진입하든 
        //다른 모든 정점과 연결된 정점들은 확실하게 순위 매길 수 있는 애들임 걔네 카운팅해서 리턴시키면 됨
        
        for(int i=1; i<=n; i++){
            if(cnt[i] == n-1) answer++;
        }
      
        
        return answer;
    }
}