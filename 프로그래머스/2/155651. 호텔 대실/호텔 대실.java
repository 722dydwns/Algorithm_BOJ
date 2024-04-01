import java.util.*;

class Room implements Comparable<Room>{
    int st, ed;
    Room(int st, int ed){
        this.st = st;
        this.ed = ed;
    }
    @Override
    public int compareTo(Room o){
        // if(this.ed == o.ed) return this.st - o.st;
        // return this.ed - o.ed;//기본 끝 시간 오름차순 정렬 
        
        
        if (this.st != o.st) return this.st - o.st; // 1 - 시작 시간이 빠른 순서로 정렬
        return this.ed - o.ed; // 2 - 끝나는 시간이 빠른 순서로 정렬
    }
}

class Solution {
    //getTime
    public static int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        
        return 60 * H + M;
    }
    
    //솔루션 함수 
    public int solution(String[][] book_time) {
        int answer = 0;
        int N = book_time.length;//방 개수 
        List<Room> roomList = new ArrayList<>();
  
        for(String[] tmp : book_time){
            int st = getTime(tmp[0]);
            int ed= getTime(tmp[1]);
            roomList.add(new Room(st, ed));
        }
        //ed 시간 오름차순 정렬
        Collections.sort(roomList);
        
        boolean[] visited= new boolean[N];
        for(int i=0; i<roomList.size(); i++){
            Room cur = roomList.get(i);
            if(visited[i]) continue;
            visited[i] = true;
            answer++;
            
            System.out.println(i);
            
            for(int j=i+1; j<roomList.size(); j++){
                if(cur.ed + 10 <= roomList.get(j).st && !visited[j]){ // 한번 체크했던 room은 넘어가도록 !visited[j] 추가
                    visited[j] = true;
                    cur = roomList.get(j);
                }
            }
        }
        return answer;
    }
}