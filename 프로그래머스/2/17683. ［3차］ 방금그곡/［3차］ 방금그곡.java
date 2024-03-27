import java.util.*;
class Solution {
    static String answer;
    static String[] result;
    public String solution(String m, String[] musicinfos) {
        // answer None으로 초기화
        answer = "(None)";

        // 정답을 저장할 배열 선언 (재생시간, 제목)
        result = new String[2];

        // musicinfos 길이만큼 순회
        for (int i = 0; i < musicinfos.length; i++) {
            String[] temp = musicinfos[i].split(",");
            // 플레이 타임
            int time = playTime(temp);

            // 재생 시간에 맞춰 악보 만들기
            List<String> list = new ArrayList<>(make(temp, time));

            // 조합 검사
            combination(list, time, temp, m);
        }

        // result 배열에서 복사
        if(result[1] != null) {
            answer = result[1];
        }

        return answer;
    }
    // 재생시간을 계산하는 메서드
    static int playTime(String[] temp) {
        // 시간을 분으로 변환하여 시간 반환
        int difHour = Integer.parseInt(temp[1].split(":")[0]) - Integer.parseInt(temp[0].split(":")[0]);
        int difMinute = Integer.parseInt(temp[1].split(":")[1]) - Integer.parseInt(temp[0].split(":")[1]);
        int time = 0;
        if (difHour != 0) {
            time += difHour * 60;
        }
        time += difMinute;
        return time;
    }

    // 재생 시간에 맞춰 악보를 만드는 메서드
    static List<String> make(String[] temp, int time) {
        int cnt = 0;
        int idx = 0;
        List<String> list = new ArrayList<>();
        while (cnt < time) {
            // idx가 temp의 사이즈를 벗어나면 0으로 초기화
            if (idx >= temp[3].length()) {
                idx = 0;
            }
            // 다음 문자가 #이라면 #추가하여 list에 저장
            if (idx + 1 < temp[3].length() && temp[3].charAt(idx + 1) == '#') {
                list.add(temp[3].charAt(idx) + "#");
                idx += 2;
                cnt++;
                continue;
            }
            list.add(String.valueOf(temp[3].charAt(idx++)));
            cnt++;
        }
        return list;
    }

    // 만들어진 악보로 조합 만들기
    static void combination(List<String> list, int time, String[] temp, String m) {
        // idx부터 list의 크기만큼 문자열 조합을 생성하여 m과 같은지 비교
        int idx = 0;
        while (idx < list.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = idx; i < list.size(); i++) {
                sb.append(list.get(i));
                // 만들어진 조합이 m과 같으면
                if (sb.toString().equals(m)) {
                    // result 배열이 비어있다면 (처음으로 m과 같은 조합 발견)
                    if(result[0] == null) {
                        result[0] = String.valueOf(time);
                        result[1] = temp[2];
                        continue;
                    }
                    // 문자열이 같고 재생시간이 길다면 result 배열 업데이트
                    if (time > Integer.parseInt(result[0])) {
                        result[0] = String.valueOf(time);
                        result[1] = temp[2];
                    }
                }
            }
            idx++;
        }
    }
}