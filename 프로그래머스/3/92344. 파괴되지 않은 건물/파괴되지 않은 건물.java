class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        //1씩 더 크게 
        int[][] sums = new int[n+1][m+1];
        
        for(int[] sk : skill){
            int degree = sk[0] == 1 ? -sk[5] : sk[5];//공격,회복 여부에 따라 
            int sr = sk[1], sc = sk[2], er = sk[3], ec = sk[4];
            
            sums[sr][sc] += degree;//누적 
            sums[sr][ec+1] += (-degree);//반대 부호로 
            
            sums[er+1][sc] += -degree;
            sums[er+1][ec+1] += degree;
        }
        
        for(int c= 0; c<m; ++c){
            for(int r=  1; r<n; ++r){
                sums[r][c] += sums[r-1][c];
            }
        }
        
        for(int r=0; r<n; ++r){
            for(int c=1; c<m; ++c){
                sums[r][c] += sums[r][c-1];
            }
        }
        
        int answer = 0;
        
        for(int r=0; r<n; ++r){
            for(int c=0; c<m; ++c){
                board[r][c] += sums[r][c];
                if(board[r][c] > 0) answer++;
            }
        }
        
        return answer;
    }
}