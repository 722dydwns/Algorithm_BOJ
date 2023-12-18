import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] x : clothes){
            String name = x[0];
            String type = x[1]; //key로 두고
            
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int value = 1;
        int answer = 0;
        
        for(String key : map.keySet()){
            value *= (map.get(key) + 1);
        }
        answer = value -1;
        
        return answer;
    }
}