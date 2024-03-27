import java.util.*;
class Solution {
    private static List<int[]> list = new ArrayList<>();
    //recursive
    private static void recursive(int cnt, int st, int mid, int ed){
        if(cnt == 0) return;
        
        recursive(cnt-1, st, ed, mid);
        list.add(new int[] {st, ed});
        recursive(cnt-1, mid, st, ed);
    }
    
    //솔루션함수 
    public int[][] solution(int n) {
        
        recursive(n, 1, 2, 3);
        int[][] answer = list.stream().toArray(int[][]::new);
        
        
        
        return answer;
    }
}