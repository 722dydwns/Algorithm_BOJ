import java.util.*;

class Solution {

    private static final int MAX_H = 6;

    public List<Integer> solution(long[] numbers) {
        List<Integer> answer = new ArrayList<>();

        for (long number : numbers) {
            answer.add(solution(number));
        }

        return answer;
    }

    private int solution(long number) {
        //1) 이진수로 변환
        String binaryString = Long.toBinaryString(number);

        // 왼쪽에 더할 수 있는 0 개수
        int canAddZeroCount = binaryString.length() - 1;
        for (int addZeroCount = 0; addZeroCount <= canAddZeroCount; addZeroCount++) {
            String zeros = "";
            for (int i = 0; i < addZeroCount; i++) {
                zeros += "0";
            }

            String curBinaryString = zeros + binaryString;
            if (isPerfectBinaryTreeNodeCount(curBinaryString.length())) {
                if (canMakeTree(curBinaryString)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean isPerfectBinaryTreeNodeCount(int length) {
        for (int h = 1; h <= MAX_H; h++) {
            if (length == (int)Math.pow(2, h) - 1) {
                return true;
            }
        }

        return false;
    }

    private boolean canMakeTree(String tree) {
        // 항상 tree.length() 는 홀수 이다.

        if (tree.length() == 1) {
            return true;
        }

        int midIndex = tree.length() / 2;

        if (tree.charAt(midIndex) == '1') {
            // 일단 현재 상태에서 루트가 1 인걸 확인 -> 좌우 자식트리 확인
            return canMakeTree(tree.substring(0, midIndex)) && canMakeTree(tree.substring(midIndex + 1, tree.length()));
        } else {
            // 현재 루트가 0 -> 자식 노드들이 전부 더미노드 즉 0이여야 함
            if (tree.contains("1")) {
                return false;
            } else {
                return true;
            }
        }
    }
}