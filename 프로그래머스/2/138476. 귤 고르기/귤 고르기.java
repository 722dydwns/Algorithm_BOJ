import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int cnt = 0;
        int sum = 0;//고를 귤의 개수 
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0)+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for(int x : list){
            if(sum + x >= k){
                cnt++;
                break;
            }else{
                sum += x;
                cnt++;
            }
        }
        
        return cnt;
    }
}