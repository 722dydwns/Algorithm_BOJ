import java.util.*;
class Solution {
    static int count;
    //len 길이에 맞게 구성
    static String getProblem(String tmp, int len){
        String ans = "";
        if(tmp.length() >= len){ //크다면 자르기
             ans = tmp.substring(0, len);//길이만큼 자름
        }else{//작다면 그 길이 만큼 맞춰 구성
            int n = len / tmp.length();
            int m = len % tmp.length();
            
            for(int i=0; i<n; i++){ //몫 횟수만큼 구성해두고 
                ans += tmp;
            }
            
            ans += tmp.substring(0, m);//나머지만큼 문자열 구성 
        }
        return ans;
    }
    
    //DFS  
    static void DFS(int lv, String num, int[] answers){
        if(lv == answers.length){
            return;
        }
        
        //현재 lv의 숫자 == answer[lv] 이면 count++처리해서 다음 깊이 탐색 
        if(Character.getNumericValue(num.charAt(lv)) == answers[lv]) count++;
        
        DFS(lv+1, num, answers);
       
    }
    
    //솔루션 함수 
    public List<Integer> solution(int[] answers) {
        List<Integer> answer= new ArrayList<>();
        
        int len = answers.length;
        
        //정답 길이만큼만 답지 문장려을 재구성을 한다.
        String first  = getProblem("12345", len);
        String second = getProblem("21232425", len);
        String third = getProblem("3311224455", len);
        
        int[] cnt = new int[4];
        //DFS 각 탐색하여 일치 문자열 개수 count 리턴받기
        count = 0;
        DFS(0, first, answers);
        int one = count;
        cnt[1] = one; 
        
        count = 0;
        DFS(0, second, answers);
        int two = count;
        cnt[2] = two;
        
        count = 0;
        DFS(0, third, answers);
        int three = count;
        cnt[3] = three;
        
        int max = Math.max(one, Math.max(two, three));
        
        for(int i=0; i<cnt.length; i++){
            if(cnt[i] == max){
                answer.add(i);//그 인덱스를 담음 
            }
        }
    
        return answer;
    }
}