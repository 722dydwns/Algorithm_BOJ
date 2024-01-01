import java.util.*;

class Solution {
    static List<ArrayList<Integer>> graph;
    static boolean[] visited;
    
    static void DFS(int val){
        visited[val] = true;
        
        for(int nx : graph.get(val)){
            if(!visited[nx]) {
                DFS(nx);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<computers.length; i++){
            for(int j=0; j<computers.length; j++){
                if(computers[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                DFS(i);
            }
        }

        return answer;
    }
}