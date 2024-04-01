import java.util.*;
class Edge implements Comparable<Edge>{
    int e, v;
    Edge(int e, int v){
        this.e = e;
        this.v =v;
    }
    public int compareTo(Edge o){
        return this.v- o.v;
    }
}
class Solution {
    static int[] distance;
    static List<List<Edge>> graph;
    //다익스트라 함수
    public static int dijkstra(int s, int k){
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(s, 0));
        
        while(!pQ.isEmpty()){
            Edge cur = pQ.poll();
            if(cur.v > distance[cur.e]) continue;
            
            for(Edge nx : graph.get(cur.e)){
                if(distance[nx.e] > distance[cur.e] + nx.v){
                    distance[nx.e] = distance[cur.e] + nx.v;
                    pQ.offer(new Edge(nx.e, distance[nx.e]));
                }
            }
        }
        
        int ans = 0;
        for(int i=1; i<distance.length; i++){
            if(distance[i] > k) ans++; 
        }
        return distance.length-1-ans;
    }
    
    //솔루션 함수 
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }
        distance = new int[N+1];
        
        for(int[] x :road){
            //양방향 간선
            int a = x[0];
            int b = x[1];
            int v = x[2];
            graph.get(a).add(new Edge(b, v));
            graph.get(b).add(new Edge(a, v));
        }
        
        answer = dijkstra(1, K);

        return answer;
    }
}