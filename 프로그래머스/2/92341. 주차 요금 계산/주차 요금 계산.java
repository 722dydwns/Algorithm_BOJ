import java.util.*;

class Solution {

    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        Map<String, Integer> ans = new TreeMap<>(Comparator.comparingInt(Integer::parseInt));

        for (int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            String time = st.nextToken();
            String carNumber = st.nextToken();
            String state = st.nextToken();

            if (state.equals("IN")) {
                map.put(carNumber, time);
                continue;
            }

            int min = getMin(time, map.get(carNumber));

            ans.put(carNumber, ans.getOrDefault(carNumber, 0) + min);
            map.remove(carNumber);
        }

        //출차하지 않은 차량은 11:59분에 출차했다고 설정
        if (!map.isEmpty()) {
            for (String carNumber : map.keySet()) {
                int min = getMin("23:59", map.get(carNumber));
                ans.put(carNumber, ans.getOrDefault(carNumber, 0) + min);
            }
        }

        return getAnswer(ans, fees);
    }

    private static int[] getAnswer(Map<String, Integer> ansMap, int[] fees) {
        List<Integer> ans = new ArrayList<>();

        for (String carNumber : ansMap.keySet()) {
            int min = ansMap.get(carNumber);
            int fee = 0;

            if (min <= fees[0]) { //기본 시간 이하라면 기본요금 부과
                fee += fees[1];
            } else { //기본 시간 이상이면 기본 요금 + 단위 시간 계산해 단위 요금 부과
                fee += (((int)Math.ceil(((double)min - fees[0]) / fees[2])) * fees[3]) + fees[1];
            }

            ans.add(fee);
        }
        return ans.stream()
            .mapToInt(Integer::intValue).toArray();
    }

    private static int getMin(String outTime, String inTime) {
        StringTokenizer st = new StringTokenizer(outTime, ":");
        int o1 = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        st = new StringTokenizer(inTime, ":");
        int o2 = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        return o1 - o2;
    }

}