import java.util.*;
class Solution {

    static int depth;
    static int min = Integer.MAX_VALUE;
    static int calc = 0;
    static boolean[] visit;

    public int solution(int[] picks, String[] minerals) {

        /**
        * pickList = 곡괭이를 담은 리스트
        * 다이아: 0, 철: 1, 돌: 2
        * 개수별로 리스트에 중복되어 들어간다.
        * ex) 다이아 1, 철 3, 돌 1 -> pickList = [0, 1, 1, 1, 2];
        */
        int ea = 0;
        ArrayList<Integer> pickList = new ArrayList<>();
        for (int i = 0; i < picks.length; i++) {
            for (int j = 0; j < picks[i]; j++) {
                if (picks[i] > 0) {
                    pickList.add(i);
                    ea++;
                }
            }
        }

        /**
        * 종료조건
        * 광물을 5개씩 묶은 묶음의 개수 or 곡괭이의 개수
        * 광물을 모두 캐거나 곡괭이가 모두 소진되면 종료하기 위함
        */
        depth = Math.min((int) Math.ceil((double) minerals.length / 5), ea);

        visit = new boolean[pickList.size()];        
        dfs(0, pickList, minerals);

        return min;
    }

    public static void dfs(int idx, ArrayList<Integer> pickList, String[] minerals) {

        // 종료 조건, 계산 도중 min 이상이 되면 더 계산할 필요가 없으므로 리턴!
        if (calc >= min) return;

        // 종료 조건, 최솟값을 계산하고 리턴!
        if (idx == depth) {
            min = Math.min(min, calc);
            return;
        }

        // 탐색!
        for (int i = 0; i < pickList.size(); i++) {
            if (!visit[i]) {
                int tmp = fatigue(pickList.get(i), idx, minerals);
                visit[i] = true;
                calc += tmp;
                dfs(idx+1, pickList, minerals);
                visit[i] = false;
                calc -= tmp;
            }
        }
    }

    public static int fatigue(int num, int st, String[] minerals) {
        /**
        * st = 시작 인덱스
        * range = 시작 인덱스 + 5 or 광물 마지막 인덱스
        */
        st = st * 5;
        int range = Math.min(st+5, minerals.length);
        int sum = 0;

        for (int i = st; i < range; i++) {
            switch (minerals[i]) {
                case "diamond":
                    sum += num == 0 ? 1 : num == 1 ? 5 : 25;
                    break;

                case "iron":
                    sum += num == 0 ? 1 : num == 1 ? 1 : 5;
                    break;

                case "stone":
                    sum += 1;
                    break;
            }
        }

        return sum;
    }
}