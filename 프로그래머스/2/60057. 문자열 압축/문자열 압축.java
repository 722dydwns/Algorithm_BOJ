import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int length = 1; length <= s.length(); length++) {
            List<String> tokens = getSplitTokens(s, length);

            StringBuilder compressedString = getCompressedString(tokens);

            if (compressedString.length() < answer) {
                answer = compressedString.length();
            }
        }

        return answer;
    }

    private List<String> getSplitTokens(String s, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < s.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > s.length()) {
                endIndex = s.length();
            }
            tokens.add(s.substring(startIndex, endIndex));
        }
        return tokens;
    }

    private StringBuilder getCompressedString(List<String> tokens) {
        StringBuilder builder = new StringBuilder();
        String last = "";
        int count = 0;
        for (String token : tokens) {
            if (token.equals(last)) {
                // 이전 토큰과 현재 토큰이 같을 때
                count++;
            } else {
                // 새로운 토큰이 등장한 경우
                if (count > 1) builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if (count > 1) builder.append(count);
        builder.append(last);
        return builder;
    }
}