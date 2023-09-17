class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        int cnt1 = 0, cnt2 = 0;
        for(int x : num_list){
          if(x % 2 == 0) {
              cnt1++;
          }else{
              cnt2++;
          }
        }
        
        answer[0] = cnt1;
        answer[1] = cnt2;
        
        return answer;
    }
}