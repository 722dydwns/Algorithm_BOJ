import java.util.*;

class Solution {
    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};
    
    //DFS
    static void DFS(String str, int len){
        list.add(str);
        if(len == 5) return;
        for(int i=0; i<5; i++){
            DFS(str+words[i], len+1);
        }
    }
    
    //솔루션
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        
        DFS("", 0);
        int size = list.size();
        for(int i=0; i<size; i++){
            if(list.get(i).equals(word)){
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}