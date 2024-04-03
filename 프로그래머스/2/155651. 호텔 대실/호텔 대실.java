import java.util.*;
class Room implements Comparable<Room>{
    int st, ed;
    Room(int st, int ed){
        this.st = st;
        this.ed = ed;
    }
    public int compareTo(Room o){
        if(this.st == o.st) return this.ed - o.ed;//시작값 같으면 e 오름차순
        return this.st-o.st;//기본 시작 시간 오름차순 정렬 
    }
}
class Solution {
    public int getTime(String x){
        int H = Integer.parseInt(x.split(":")[0]);
        int M = Integer.parseInt(x.split(":")[1]);
        return 60 * H + M;
    }
    //솔루션 함수 
    public int solution(String[][] book_time) {
        int answer = 0;
        
        List<Room> roomList = new ArrayList<>();
        for(String[] x : book_time){
            int st = getTime(x[0]);
            int ed = getTime(x[1]);
            roomList.add(new Room(st, ed));
        }
        
        Collections.sort(roomList);
        boolean[] visited= new boolean[book_time.length];
        //시작시간 오름차순 기준 
        for(int i=0; i<roomList.size(); i++){
            if(visited[i]) continue;
            Room target = roomList.get(i);
            visited[i] =true;
            answer++;
            for(int j=i+1; j<roomList.size(); j++){
                if(!visited[j] && roomList.get(j).st >= target.ed + 10){
                    visited[j] = true;
                    target = roomList.get(j);
                }
            }
        }
        
        return answer;
    }
}