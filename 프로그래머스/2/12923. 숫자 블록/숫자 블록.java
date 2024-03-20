import java.util.*;

class Solution {
    private static long Limit =  10000000;
    //약수 중 가장 max 반환
    public static int getValueMax(int val){
        if (val == 1) {
            return 0;
        }

        int answer = 1; //없으면 기본 1리턴

        for (int i = 2; i <= Math.sqrt(val); i++) { 
            if (val % i == 0) {
                int expect = val / i;
                if (expect > Limit) {
                    answer = i;
                } else {
                    answer = expect;
                    return answer;
                }
            }
        }

        return answer;
    }

    //솔루션 함수
    public int[] solution(long begin, long end) {
        long N = end- begin +1;

        int[] answer = new int[(int) N];

        for(int i= (int)begin ; i <= (int) end; i++){
            answer[i - (int)begin] = getValueMax(i); // answer 인덱스 접근 유의
        }

        return answer;
    }
}