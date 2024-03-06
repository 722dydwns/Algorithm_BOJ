import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> Q1 = new LinkedList<>();
        Queue<Long> Q2 = new LinkedList<>();
        
        long sum1 = 0;
        long total = 0;
        //두 큐 사이즈가 같기 때문에 한번의 순회로 합과 Q에 add 처리 가능 
        for(int i=0; i<queue1.length; i++){
            total += (queue1[i] + queue2[i]);
            Q1.offer(Long.valueOf(queue1[i]));
            Q2.offer(Long.valueOf(queue2[i]));
            sum1 += queue1[i];
        }

		if( total % 2 != 0) return -1;
        
        long target = total / 2; //타겟 값 
        
        int count = 0;
				
        while(true){
	        // 넉넉 잡아 두 바퀴를 돌아도 안되면 안됨
            if(count > (queue1.length+queue2.length) *2) return -1;
            if(sum1 == target) break;
            if(sum1 > target){
                sum1 -= Q1.peek();
                Q2.offer(Q1.poll());
            }else{
                sum1 += Q2.peek();
                Q1.offer(Q2.poll());
            }
            count++;
        }
        return count;
    }
}