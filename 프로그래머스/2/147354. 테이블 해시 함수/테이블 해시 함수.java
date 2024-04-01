import java.util.*;
class Solution {
    //솔루션 함수 
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //정렬 조건 - col번째 값 기준 오름차순 && 같은 경우 첫 번째 값 오름차순 
        Arrays.sort(data, (o1, o2) -> {
            if(o1[col-1] == o2[col-1]) return o2[0] - o1[0];
            return o1[col-1] - o2[col-1];
        });
        
        //정렬된 상태에서 row_bgin~end 까지는 XOR 값을 해시값으로 변환하기 
        for(int i=row_begin-1; i<row_end ; i++){
            int S_i = 0;
            for(int d : data[i]) S_i += (d % (i+1));
            
            answer ^= S_i;
        }
        
        
        return answer;
    }
}