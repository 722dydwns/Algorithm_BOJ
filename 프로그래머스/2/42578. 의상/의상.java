import java.util.*;
class Solution {
    //솔루션 함수 
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String [] c : clothes){
            //종류별로 담음 
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }
        
        int value = 1;
        
        for(String key : map.keySet()){
            value *= (map.get(key) + 1);//모두 선택하거나 모두 선택하지 않는 케이스 (1)    
        }
        //모두 선택하는 케이스 제외 1개
        
        return value - 1;
    }
}