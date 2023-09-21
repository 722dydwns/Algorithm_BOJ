class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int sum1 = 1, sum2 =0;
        
        for(int i=0; i<num_list.length; i++){
            sum1 *= num_list[i];
            sum2 += num_list[i];
        }
        
        if(sum1 < sum2*sum2) {
            answer = 1;
        }
        
        
        return answer;
    }
}