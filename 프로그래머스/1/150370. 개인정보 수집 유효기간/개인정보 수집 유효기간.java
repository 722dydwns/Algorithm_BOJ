import java.util.*;

class Info {
    int yy, mm, dd;

    Info(int yy, int mm, int dd) {
        this.yy = yy;
        this.mm = mm;
        this.dd = dd;
    }
}

class Solution {
    static Map<String, Integer> map;

    // getInfo
    public static Info getInfo(String date) {
        String[] str = date.split("\\.");
        return new Info(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
    }

    // type 별 Info 반환
    public static Info getEndInfo(Info info, String type) {
        int plusMon = map.get(type);

        int yy = info.yy;
        int mm = info.mm + plusMon;
        int dd = info.dd;

        while (mm > 12) {
            mm -= 12;
            yy++;
        }

        return new Info(yy, mm, dd);
    }

    // 솔루션 함수
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        map = new HashMap<>();
        for (String tr : terms) {
            String[] tmp = tr.split(" ");
            map.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        Info targetInfo = getInfo(today);

        int idx = 0;
        List<Integer> answer = new ArrayList<>();

        for (String pv : privacies) {
            idx++;
            String[] tmp = pv.split(" ");

            String date = tmp[0];
            String type = tmp[1];

            Info info = getInfo(date);
            Info endInfo = getEndInfo(info, type);

            if (targetInfo.yy > endInfo.yy) {
                answer.add(idx);
            } else if (targetInfo.yy == endInfo.yy && targetInfo.mm > endInfo.mm) {
                answer.add(idx);
            } else if (targetInfo.yy == endInfo.yy && targetInfo.mm == endInfo.mm && targetInfo.dd >= endInfo.dd) {
                answer.add(idx);
            }
        }

        return answer;
    }
}