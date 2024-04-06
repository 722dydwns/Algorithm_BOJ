import java.util.*;

class Solution {
    //솔루션 함수 
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            factorial *= i;
        }

        int i = 0;
        long remain = k - 1;
        // k가 1부터 시작하므로

        while (i < n) {
            factorial = factorial / (n - i);
            long value = remain / factorial;
            answer[i++] = list.get((int)value);
            list.remove((int)value);
            remain = remain % factorial;
        }

        return answer;
    }
}