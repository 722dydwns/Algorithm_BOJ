class Solution {
    public int[] solution(int start, int end_num) {
        
        int len = start - end_num + 1;
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[i] = start;
            start--;
        }
        
        
        
        return answer;
    }
}