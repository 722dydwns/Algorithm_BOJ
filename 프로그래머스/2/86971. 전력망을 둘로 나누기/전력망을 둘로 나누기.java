import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    
    static int DFS(int val, boolean[] visited){
        visited[val] = true;
        int cnt = 1;
        
        for(int nx : graph.get(val)){
            if(!visited[nx]){
                cnt+= DFS(nx, visited);
            }
        }
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++ ){
            graph.add(new ArrayList<>());
        }
        int min = Integer.MAX_VALUE;
        visited = new boolean[n+1];
        
        for(int[] x : wires){
            int a = x[0];
            int b = x[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for(int[] x : wires){
            int a = x[0];
            int b = x[1];
            
            boolean[] visited = new boolean[n+1];
            //하나씩 끊기 
            graph.get(a).remove(Integer.valueOf(b));
            graph.get(b).remove(Integer.valueOf(a));
            
            int count = DFS(1, visited);
            
            int diff = Math.abs(count - (n-count));
            min = Math.min(min, diff);
            
            //다시 연결 처리 
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        return min;
    }
}