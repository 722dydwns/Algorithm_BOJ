import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length(); length++) {
            List<String> tokens = getSplitTokens(s, length);

            int compLen = getCompressedString(tokens);
            
            answer = Math.min(answer, compLen);
        }

        return answer;
    }

    private List<String> getSplitTokens(String s, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < s.length(); startIndex += length){
            int endIndex = startIndex + length;
            if (endIndex > s.length()) {
                endIndex = s.length();
            }
            tokens.add(s.substring(startIndex, endIndex));
        }
        return tokens;
    }
    private int getCompressedString(List<String> list){
        String answer="";
        String tmp= list.get(0);
        int cnt =1;
        for(int i=1; i<list.size(); i++){
            if(tmp.equals(list.get(i))){
                cnt++;
            }else{
                if(cnt>1) answer += String.valueOf(cnt);
                cnt = 1;
                answer += tmp;
                tmp = list.get(i);
            }
        }
        //내가 다른 글자 나타날 때마다 answer에 누적해서 String을 합쳐주고 있기 떄문에
        //필연적으로 마지막 문자 종류는 (더 이상 자기와 다른 다음 문자가 없으므로) 붙이지 못하고 반복문을 탈출한다.
        //따라서 마지막 문자는 반복문에 나와서 처리해줄 필요가 있다.
        if(cnt > 1) answer += String.valueOf(cnt);
        answer += tmp;
        return answer.length();
    }
}