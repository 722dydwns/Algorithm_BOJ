import java.util.*;
class Solution {    
    public int solution(int[] q1, int[] q2) {
        int answer = 0;
        
        long total = 0; // 두 큐의 합
        long q1sum = 0; // 1번 큐의 합
        Queue<Integer> qq1 = new LinkedList<Integer>();
        Queue<Integer> qq2 = new LinkedList<Integer>();
        
        for(int i = 0; i < q1.length; i++) {
            total += q1[i] + q2[i];
            q1sum += q1[i];
            qq1.add(q1[i]);
            qq2.add(q2[i]);
        }
        
        if(total%2!=0) return -1; //만약 두큐의합이 홀수면 같게 못만듦.
        
        long target = total/2;
        while(true) {
            if(answer>(q1.length+q2.length)*2) return -1;//이땐 더 순회해도 못 만듦
            
            if(q1sum==target) break; // 한쪽의 큐 합을 계산했을 때 전체의 반이라면 종료한다.
            else if(q1sum>target){   // q1sum이 target보다 크다면 
                q1sum -= qq1.peek(); // 큐1 합에는 큐2의 것을 빼고
                qq2.add(qq1.poll()); // 큐2에 큐1의 것을 넣어줍니다.
            }else{                   // q2sum이 target보다 작다면
                q1sum += qq2.peek(); // 큐1 합에는 큐2의 것을 더하고
                qq1.add(qq2.poll()); // 큐1에 큐2의 것을 넣어줍니다.
            }
            answer++;
        }
        
        return answer;
    }
}