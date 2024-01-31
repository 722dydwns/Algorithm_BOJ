import java.util.*;

class Solution {
    //솔루션 함수 
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, int[]> count = new HashMap<>(); //정점번호, (진출차수, 진입차수)
        
        for(int[] x : edges){
            int a = x[0];
            int b = x[1];
            //a->b 순의 방향 간선 
            if(!count.containsKey(a)){//기존에 없는 정점이라면 
                count.put(a, new int[] {0, 0});
            }
            if(!count.containsKey(b)){
                count.put(b, new int[] {0, 0});
            }
            
            count.get(a)[0]++; //a 진출차수 개수 ++처리
            count.get(b)[1]++; //b 진입차수 개수 ++처리
        }
        
        //순회하며 정점의 진출, 진입 가선  수 체크하며 판별
        for(int key : count.keySet()){
            int[] cur = count.get(key);//현재 정점의 차수 정보 배열 cur
            int in = cur[1]; //cur 진입차수
            int out = cur[0]; //cur 진출차수
                          
            if(in == 0 && out >= 2){ //생성된 정점 : 진입X, 진출2개 이상임
                answer[0] = key;//정점 번호 담기 
            }else if(in > 0 && out == 0){
                //막대 그래프
                answer[2]++;
            }else if(in >= 2 && out>=2){
                //8자 그래프
                answer[3]++;
            }
        }
                          
        //도넛 그래프
        answer[1] = count.get(answer[0])[0] - answer[2] - answer[3];
        
        
        return answer;
    }
}