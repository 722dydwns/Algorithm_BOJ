import java.util.*;

class Solution {
    static int getTime(String str){
        int H = Integer.parseInt(str.split(":")[0]);
        int M = Integer.parseInt(str.split(":")[1]);
        
        return 60 * H + M;//분
    }
    
    static String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H")
            .replaceAll("D#", "I").replaceAll("F#", "J").replaceAll("G#", "K")
            .replaceAll("A#", "L").replaceAll("B#", "M"); // 문제에 없는 B# 코드 추가해야 [34]통과
        
        return oldMelody;
    }
    //솔루션 함수 
    public String solution(String m, String[] musicinfos) {
        String answer ="(None)";
        int maxPlayTime = -1;
        m = changeMelody(m);
        System.out.println("m : "+ m);
        for(String x : musicinfos){
            String[] tmp = x.split(",");
            
            int st = getTime(tmp[0]);
            int ed = getTime(tmp[1]);
            int time = ed - st;
            
            String name = tmp[2];
            String melodyInfo = changeMelody(tmp[3]);
            System.out.println("멜로디: " + melodyInfo);
            //재생 시간 > 음악 길이
            if(time > melodyInfo.length()){
                StringBuilder newMel = new StringBuilder();
                for(int i=0; i<time / melodyInfo.length() ;i++){
                    newMel.append(melodyInfo);
                }
                
                //나머지 만큼 악보에서 잘라 붙임
                newMel.append(melodyInfo.substring(0, time % melodyInfo.length()));
                melodyInfo = newMel.toString();
                System.out.println("바꿈 " + melodyInfo);
            }else{
                melodyInfo= melodyInfo.substring(0, time);
                System.out.println("바꿈 " + melodyInfo);
            }
        
            if(melodyInfo.contains(m) && time > maxPlayTime){
                answer = name;
                maxPlayTime = time;
            }
        }   
        
        return maxPlayTime != -1 ? answer : "(None)";
    }
}