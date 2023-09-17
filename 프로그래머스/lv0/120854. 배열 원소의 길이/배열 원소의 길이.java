class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for(int i=0; i<strlist.length; i++){
            String tmp = strlist[i];
            answer[i] = tmp.length();
        }
        
        return answer;
    }
}