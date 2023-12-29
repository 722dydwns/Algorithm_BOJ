import java.util.*;

class Solution {
    static Map<Integer, Integer> map = new HashMap<>();
    //isPrime
    static boolean isPrime(int val){
        if(val == 0 || val == 1) return false;
        
        for(int i=2; i<=(int) Math.sqrt(val); i++){
            if(val % i == 0) return false;
        }
        return true;
    }
    
    //DFS
    static void DFS(String tmp, String n){
        if(!tmp.equals("")) {
            int num = Integer.parseInt(tmp);
            if(isPrime(num)){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        for(int i=0; i<n.length(); i++){
            DFS(tmp+n.charAt(i), n.substring(0, i) + n.substring(i+1));
        }
    }
    
    //solution 
    public int solution(String numbers) {
        int answer = 0;
        
        DFS("", numbers);
        
        answer = map.size();
        
        return answer;
    }
}