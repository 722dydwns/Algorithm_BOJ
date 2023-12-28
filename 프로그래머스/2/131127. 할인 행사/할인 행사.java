import java.util.*;

class Solution {
    
    //solution
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);//미리 넣어두기 
        }
        
        for(int i=0; i<discount.length - 10 + 1; i++){
            Map<String, Integer> dmap = new HashMap<>();
            
            for(int j=0; j<10; j++){
                dmap.put(discount[i+j], dmap.getOrDefault(discount[i+j], 0)+1);
                boolean flag = true;
                
                for(String key : map.keySet()){
                    if(map.get(key) != dmap.get(key)){
                        flag = false;
                        break;
                    }
                }
                
                if(flag) answer++;
            }
        }
        
        
        return answer;
    }
}