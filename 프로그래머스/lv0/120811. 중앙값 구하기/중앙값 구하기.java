import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int tmp = array.length / 2;
        answer = array[tmp];
        return answer;
    }
}