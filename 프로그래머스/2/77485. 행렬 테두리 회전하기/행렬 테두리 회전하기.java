import java.util.*;
class Solution {
    public int[][] map;
    public ArrayList<Integer> answer;
    //회전시키기 
    public int rotate(int[] query){
        int x1 = query[0];
        int y1=  query[1];
        int x2 = query[2];
        int y2 = query[3];
        
        int prev = map[x1][y1];
        int min = prev;
        
        //우측
        for(int i= y1+1; i<=y2; i++){
            int tmp = map[x1][i];
            map[x1][i] = prev;
            min = Math.min(min, prev);
            prev = tmp; //직전값은 기존의 값으로 세팅 
        }
        //하강
        for(int i=x1+1; i<=x2; i++){
            int tmp = map[i][y2];
            map[i][y2] = prev;
            min = Math.min(min, prev);
            prev = tmp; //기존값으로 세팅 
        }
        
        //좌측
        for(int i=y2-1; i>=y1; i--){
            int tmp = map[x2][i];
            map[x2][i] = prev;
            min = Math.min(min, prev);
            prev = tmp;
        }
        //상승
        for(int i=x2-1; i>=x1; i--){
            int tmp = map[i][y1];
            map[i][y1] = prev;
            min = Math.min(min, prev);
            prev = tmp;
        }
        
        return min;
    }
    //솔루션 함수 
    public List<Integer> solution(int rows, int columns, int[][] queries) {
        answer = new ArrayList<Integer>();
        // 맵 초기화
        map = new int[rows+1][columns+1];
        int num = 1;
        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= columns; j++){
                map[i][j] = num;
                num++;
            }  
            
        }
        for(int i = 0; i < queries.length; i++){
            answer.add(rotate(queries[i]));   
        }

        return answer;
    }

}