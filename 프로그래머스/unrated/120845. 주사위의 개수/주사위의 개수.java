class Solution {
    public int solution(int[] box, int n) {
        
        int answer = 1;
        for(int x : box){
            int tmp = x/n;
            answer *= tmp;
        }
        return answer;
    }
}