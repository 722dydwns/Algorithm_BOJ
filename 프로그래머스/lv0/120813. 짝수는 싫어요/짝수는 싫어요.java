class Solution {
    public int[] solution(int n) {
        int len = 0;
        if(n % 2 == 0) {
            len = n/2;
        }else{
            len = (n+1)/2;
        }
        
        int[] answer = new int[len];
        int a = 0;
        for(int i=1; i<=n; i++){
            if(i % 2 ==0) continue;
            answer[a] = i;
            a++;
        }
        
        return answer;
    }
}