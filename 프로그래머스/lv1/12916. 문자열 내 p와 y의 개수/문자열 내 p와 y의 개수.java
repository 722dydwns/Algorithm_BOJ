class Solution {
    boolean solution(String s) {
        //모두 대문자로 통일시키기 
        String tmp = s.toUpperCase();
        int pCnt = 0;
        int yCnt = 0;
        
        for(char x : tmp.toCharArray()){
            if(x == 'P'){
                pCnt++;
            }else if(x == 'Y'){
                yCnt++;
            }
        }
        //true 조건에 걸리면 true 반환하고 
        if(pCnt == 0&& yCnt ==0 || pCnt == yCnt) {
            return true;
        }
        //위에서 안 걸렸으면 무조건 false 리턴 
        return false;
    }
}