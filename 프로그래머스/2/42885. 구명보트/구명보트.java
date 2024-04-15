import java.util.*;
class Solution {
    
    //솔루션 함수 
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int st = 0;
        int ed = people.length-1;
        
        //정렬 오름차순
        Arrays.sort(people);
        
        while(st <= ed){
            if(people[st] + people[ed] <= limit){
                answer++;//구명보트 ++처리 
                st++;//처리 완료하니 다음 찍고
                ed--;//얘도 처리 완료라 다음 찍고
            }else{
                answer++;
                ed--; // 더 큰 거만 처리하고 다음 찍기
            }
        }
        
        return answer;
    }
}