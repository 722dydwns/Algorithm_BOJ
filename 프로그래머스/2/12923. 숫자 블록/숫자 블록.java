import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {

        int[] answer = new int[(int) (end - begin) + 1];

        for (int i = 0; i < answer.length; i++) {
            long num = begin + i;

            //약수 구하기
            int max_divisor = 1;
            for (long div = 2; div <= Math.sqrt(num); div++) {
                if (num % div == 0) {
                    //최대 10억의 제곱근이므로 약 3만으로, 천만 이하인지 검사X
                    int divisor1 = (int) div; 
                    //최대 10억 / 2,  5억이므로 천만이하인지 검사 필요함
                    int divisor2 = (int) (num / div);
                    
                    //가장 큰 약수 찾기
                    max_divisor = Math.max(max_divisor, divisor1);
                    if ( divisor2 <= 10000000)
                        max_divisor = Math.max(max_divisor, divisor2);
                }
            }
            answer[i] = max_divisor;
        }
        if (begin == 1)
            answer[0] = 0;
        return answer;
    }
}
