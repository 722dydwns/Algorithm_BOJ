import java.util.*;
class Solution {
    //솔루션 함수 
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        
        for(String sk : skill_trees){
            char[] tmp = sk.toCharArray();
            String str = "";

            for(char c : tmp){
                if(skill.contains(String.valueOf(c))){
                    str += c;
                }
            }
            list.add(str);
        }
        
        answer = skill_trees.length - list.size();
    
        for(String x : list) {
            if(skill.equals(x)) answer++;
            else{
                String tmp = skill.substring(0, x.length());
                if(tmp.equals(x)) answer++;
            }
        }
        
        return answer;
    }
}