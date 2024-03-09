import java.util.*;
class Solution {
    private int[][] map;
    private Map<String, Integer> hashMap;
    private String answer = "";
    
    //구성 만드는 함수 
    private void setMap(int upDown, int leftRight){
        //구성을 문자열로 만들어주기 
        hashMap = new HashMap<>();
        hashMap.put("d",0);
        hashMap.put("l", 0);
        hashMap.put("r", 0);
        hashMap.put("u", 0);
        
        if(upDown < 0){ //음수이면 위
            hashMap.put("u", Math.abs(upDown));
        }
        if(upDown > 0){//양수이면 아래
            hashMap.put("d", Math.abs(upDown));
        }
        if(leftRight < 0){//음수이면 왼쪽
            hashMap.put("l", Math.abs(leftRight));
        }
        if(leftRight > 0){
            hashMap.put("r", Math.abs(leftRight));
        }
    }
    //정답 구성함수
    private void addAnswer(String c, int count){
        for(int i=0; i<count; i++){
            answer += c;
        }
    }
    
    //솔루션 함수 
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        //1) S -> E 
        int upDown = r - x; //음수 : 위, 양수 : 아래 
        int leftRight = c -y; //음수  : 왼, 양수 : 오른쪽
        //target = 구성의 절대적 수 a
        int target = Math.abs(upDown) + Math.abs(leftRight);
        
        //2) k와 target 비교
        if ( k < target || (k - target) % 2 == 1) return "impossible";
        
        // 의미없는 행동 해야하는 개수
        int notMean = k - target;
        
        setMap(upDown, leftRight);
        
        //3) 이동 문자 구성
        //d로 일단 가고 
        addAnswer("d", hashMap.get("d"));
        
        //d로 더 갈 수 있는지 개수 
        int dMin = Math.min(notMean/2, n - (x + hashMap.get("d")));
        
        addAnswer("d", dMin);
        
        //u도 (d)만큼 의미없이 간 거 되돌아오기 위함 
        int tmp = hashMap.get("u");
        tmp += dMin;
        hashMap.put("u", tmp);
        
        notMean -= (dMin * 2);//d-u 왕복한 개수를 (했다 치는거)
        
        //l로 일단 가고
        addAnswer("l", hashMap.get("l"));
        int lMin = Math.min(notMean/2, (y - hashMap.get("l") - 1));
        
        addAnswer("l", lMin);
        
        //r도 (l)만큼 의미없이 간 거 되돌아오기 위함
        hashMap.put("r", hashMap.get("r") + lMin);
        notMean -= (lMin * 2);
        addAnswer("rl", notMean/2);
        
        //이제 map에 담긴 (origin 구성을 털기)
        addAnswer("r", hashMap.get("r"));
        //이제 map에 담긴 origin u
        addAnswer("u", hashMap.get("u"));
        
        
        return answer;
    }
}