import java.util.*;

class Solution {
    private static final char FIRST_SYMBOL = 'O';
    private static final char SECOND_SYMBOL = 'X';
    private static final char EMPTY_SYMBOL = '.';

    // 선공, 후공 각각 돌 좌표(position) 을 list 형태로 가공
    // key : 바둑돌 character ('O', 'X')
    // value : position list
    private Map<Character, List<Position>> positionsMap;

    private int answer = 0; // dfs 를 재귀로 구현할거라, 매번 파라미터로 answer 넘겨주기 싫어서 전역으로 선언
    private char[][] board = new char[3][3]; // board 도 answer 와 같은 이유. + 더 편하게 char[][] 로 가공함

    public int solution(String[] board) {
        initBoard(board); // this.board 초기화
        initPositions(); // this.positionsMap 초기화

        dfs(FIRST_SYMBOL, new char[3][3]);
        return answer;
    }

    private void initBoard(String[] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = board[i].charAt(j);
            }
        }
    }

    private void initPositions() {
        positionsMap = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY_SYMBOL) {
                    continue;
                }

                if (!positionsMap.containsKey(board[i][j])) {
                    positionsMap.put(board[i][j], new ArrayList<>());
                }

                positionsMap.get(board[i][j]).add(new Position(i, j));
            }
        }
    }

    // 재귀로 dfs 구현
    // symbol : 현재 턴에 둬야 할 바둑돌 순서를 나타냄 (선공차례인지, 후공차례인지 여부)
    // curBoard : dfs 로 재귀를 돌면서 만들어가는 바둑판
    private void dfs(char symbol, char[][] curBoard) {
        if (isBingo(curBoard)) { // 현재 턴에 두려고 보니 이미 빙고 상태인 경우
            if (!isRemainPositionsExist()) { // 더이상 둘 바둑돌이 없다면?
                this.answer = 1; // 정상적인 게임인 경우
            }

            // 이미 빙고상태이므로 더이상 진행하지 않아도 됨.
            // 더 둬야 할 바둑돌이 있는 경우 -> 정상적인 게임 아닌 경우 : 어짜피 this.answer 가 0 으로 초기화되어있기 때문에 따로 값 넣어줄 필요 없음
            return;
        }

        if (!isRemainPositionsExist()) { // 현재 턴에 더이상 둘 바둑돌이 없는 경우
            this.answer = 1; // 게임의 승자는 없지만, 정상적으로 게임이 종료될 수 있다. -> 정상적인 게임 처리
            return;
        }

        // 참고 : 이 블럭은 선공(O) 은 아예 없고 후공(X) 만 있는 경우에 대한 예외처리. -> 이 부분은 dfs 밖으로 빼도 될듯 함
        if (!positionsMap.containsKey(symbol)) { // 현재 턴 (선공 or 후공) 이 둘 바둑돌이 아예 없는 경우
            if (!isRemainPositionsExist()) { // 현재 턴에 둘 바둑돌이 없으니까 더이상 게임이 진행될 수 없어야 하는데, 더 둘 수 있는 바둑돌이 있는지 확인
                this.answer = 1; // 없으면 정상적인 게임 처리
            }
            return; 
        }
        
        List<Position> positions = positionsMap.get(symbol); // 현재 턴의 좌표 리스트를 받음

        for (int i = 0; i < positions.size(); i++) {
            Position cur = positions.get(i); // cur : 현재 좌표
            if (cur.visit) { // 이미 사용한 돌이면 넘어감
                continue;
            }

            // 사용할 수 있는 좌표이면
            
            // curBoard 에 표시 하고
            curBoard[cur.i][cur.j] = symbol; 
            cur.visit = true;
            
            // 다음 dfs 로 넘어감
            dfs(symbol == FIRST_SYMBOL ? SECOND_SYMBOL : FIRST_SYMBOL, curBoard);
            
            // dfs 에서 빠져나오면 cur 표시했던거 다시 지움
            curBoard[cur.i][cur.j] = EMPTY_SYMBOL;
            cur.visit = false;
        }

    }

    // 빙고 여부
    private boolean isBingo(char[][] curBoard) {
        return isBingo(curBoard, FIRST_SYMBOL) || isBingo(curBoard, SECOND_SYMBOL);
    }

    private boolean isBingo(char[][] curBoard, char symbol) {
        return (curBoard[0][0] == symbol && curBoard[0][1] == symbol && curBoard[0][2] == symbol) ||
            (curBoard[1][0] == symbol && curBoard[1][1] == symbol && curBoard[1][2] == symbol) ||
            (curBoard[2][0] == symbol && curBoard[2][1] == symbol && curBoard[2][2] == symbol) ||
            (curBoard[0][0] == symbol && curBoard[1][0] == symbol && curBoard[2][0] == symbol) ||
            (curBoard[0][1] == symbol && curBoard[1][1] == symbol && curBoard[2][1] == symbol) ||
            (curBoard[0][2] == symbol && curBoard[1][2] == symbol && curBoard[2][2] == symbol) ||
            (curBoard[0][0] == symbol && curBoard[1][1] == symbol && curBoard[2][2] == symbol) ||
            (curBoard[2][0] == symbol && curBoard[1][1] == symbol && curBoard[0][2] == symbol);
    }

    // 아직 놔야 할 바둑돌이 있는지 확인
    private boolean isRemainPositionsExist() {
        boolean result = false;

        for (char symbol : positionsMap.keySet()) {
            result |= positionsMap.get(symbol).stream()
                .filter(position -> !position.visit)
                .count() > 0;
        }

        return result;
    }

    private class Position {
        int i, j;
        boolean visit = false; // 방문 여부

        Position(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}