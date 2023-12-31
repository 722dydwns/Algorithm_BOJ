import java.util.*;

class Solution {
    static int answer = 0;
    //DFS
    static void DFS(int lv, int sum, int[] numbers, int target){
        if(lv == numbers.length){
            if(sum == target) answer++;
            return;
        }
        
        DFS(lv+1, sum + numbers[lv], numbers, target);
        DFS(lv+1, sum - numbers[lv], numbers, target);
        
    }
    
    public int solution(int[] numbers, int target) {
        
        DFS(0, 0, numbers, target);
        
        return answer;
    }
}