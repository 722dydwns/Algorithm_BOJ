import java.util.*;

class Solution {
    private static Map<String , Integer> map;
    //솔루션 함수 
    public String[] solution(String[] players, String[] callings) {
        map = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);//인덱스랑 함께 담음 
        }
        
        for(String x : callings){
            int own = map.get(x);//현재 등수
            String beforeName = players[own-1];
            
            players[own-1] = x;
            players[own] = beforeName;
            
            //map 세팅
            map.put(x, own-1);
            map.put(beforeName, own);
        }

        
        return players;
    }
}