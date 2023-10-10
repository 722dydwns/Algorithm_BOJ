class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        int i = 0;
        for(int[] x : parts){
   
            int s=  x[0];
            int e = x[1];
            
            answer += my_strings[i].substring(s, e+1);
            i++;   
        }
     
        return answer;
    }
}