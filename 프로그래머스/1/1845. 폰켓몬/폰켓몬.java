import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int answer = 0;
        int N = nums.length;
        
        if(N/2 < map.size()) answer = N/2;
        else answer = map.size();
        
        return answer;
    }
}