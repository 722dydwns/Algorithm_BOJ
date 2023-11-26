import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<name.length; i++){
            String item = name[i];
            int val = yearning[i];
            
            map.put(item, val);
        }
        
        for(int i=0; i<photo.length; i++){
            for(String x : photo[i]){
                answer[i] += map.getOrDefault(x, 0);
            }
        }
        
        return answer;
    }
}