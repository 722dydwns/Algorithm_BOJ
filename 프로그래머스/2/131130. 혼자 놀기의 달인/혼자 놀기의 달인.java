import java.util.*;
class Solution {
    static PriorityQueue<Integer> queue;
    public int solution(int[] cards) {
        int answer = 0;
        
        // cards 크기가 선택한 숫자 n
        int n = cards.length;
        boolean[] visited = new boolean[n];
        
        // 상자 그룹의 개수를 저장한 queue
        queue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 열지 않은 상자라면
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(cards, i, visited, 0);
            }
        }
        
        // queue 크기가 1이면 1번 상자 그룹밖에 없다는 의미
        if(queue.size() != 1) {
            answer = queue.poll() * queue.poll();    
        }
        
        return answer;
    }
    static void dfs(int[] cards, int num, boolean[] visited, int cnt) {
        // 열었던 상자라면
        if(visited[num]) {
            // 상자의 개수를 queue에 저장하고 리턴
            queue.add(cnt);
            return;
        }
        visited[num] = true;
        dfs(cards, cards[num] - 1, visited, cnt + 1);
    }
}