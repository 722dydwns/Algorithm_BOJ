import java.util.*;

class Solution {
    static List<String> list;
    static String[] alpha = {"A", "E", "I", "O", "U"};
    //DFS
    static void DFS(int lv, String str){
        list.add(str);
        if(lv==5) return;
        
        for(int i=0; i<5; i++){
            DFS(lv+1, str+alpha[i]);
        }
    }
    
    public int solution(String word) {
        int answer = 0;
        
        list = new ArrayList<>();
        DFS(0, "");
        for(int i=0; i<list.size(); i++){
            if(list.get(i).equals(word)){
                return i;
            }
        }
        
        return answer;
    }
}