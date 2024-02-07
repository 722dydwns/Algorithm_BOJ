import java.util.*;
class Solution {
    static int N;
    //솔루션 함수 
    public int solution(String[] friends, String[] gifts) {
        N = friends.length;
        Map<String, Integer> idx = new HashMap<>();
        Map<Integer, Integer> pst = new HashMap<>();
        for(int i=0; i<N; i++){
            idx.put(friends[i], i);
            pst.put(i, 0);
        }
        
        int[][] map = new int[N][N];
        
        for(String x : gifts){
            String a = x.split(" ")[0];
            String b = x.split(" ")[1];
            
            //a -> b로 향함
            int A = idx.get(a);
            int B = idx.get(b);
            map[A][B]++;
            
            //선물 지수 세팅
            pst.put(A, pst.getOrDefault(A, 0) +1); //준 거 
            pst.put(B, pst.getOrDefault(B, 0) -1); //받은 거 
        }
        //다음달에 받을 선물 계산용 배열 
        int[] arr = new int[N];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==j) continue;
                //i,j 둘 사이의 관계에서 
                if(map[i][j] > map[j][i]){ //i가 준게 더 크다면 
                    arr[i]++;
                }else if(map[j][i] > map[i][j]){ //j가 준 게 더 크다면 
                    arr[j]++;
                }else if(map[i][j] == map[j][i] || map[i][j] == 0 && map[j][i] == 0){ //기록 없거나, 같다면 
                    //i, j선물 지수 비교
                    if(pst.get(i) > pst.get(j)) {
                        arr[i]++;
                    }else if(pst.get(j)> pst.get(i)){
                        arr[j]++;
                    }
                }
            }
        }
        
       int answer = 0; 
       for(int x : arr){
           answer = Math.max(answer,x);
       }
       
        return answer/2;
    }
}