import java.util.*;
class Solution {
        public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < numbers.length-1; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<Integer>(set);
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}