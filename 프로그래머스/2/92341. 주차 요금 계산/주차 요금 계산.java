import java.util.*;
class Solution {
    //시간 -> 분으로 교체
    private static int getTime(String time){
        int H = Integer.parseInt(time.split(":")[0]);
        int M = Integer.parseInt(time.split(":")[1]);
        return 60 * H + M;
    }
    
    //솔루션 함수 
    public List<Integer> solution(int[] fees, String[] records) {
        //차번호, 누적시간
        Map<String, Integer > map = new HashMap<>(); 
            
        for(String info : records){
            String time = info.split(" ")[0];
            String carNum = info.split(" ")[1];
            String inOut = info.split(" ")[2];
            
            int mTime = getTime(time); //분
            if(inOut.equals("IN")){ //입차 기록 
                map.put(carNum, map.getOrDefault(carNum, 0) - mTime); //음수로
            }else{ //출차 기록 
                map.put(carNum, map.getOrDefault(carNum, 0) + mTime); //양수로
            }
        }
        
        //빠져나온 상태에서 음수나 0으로 존재하는 경우는 출차기록이 없는 거임 출차 처리
        for(String car : map.keySet()){
            if(map.get(car) <= 0){
                int m = map.get(car);
                m += getTime("23:59");
                map.put(car, m);
            }
        }
        
        //이제 요금 계산하기 
        List<Integer> answer = new ArrayList<>();
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        for(String car : keySet){
            //기본요금 0원이 아니면서, 
            if(fees[1] != 0 && map.get(car) != 0 && map.get(car) <= fees[0]) { //기본요금 이하면 
                answer.add(fees[1]);
            }else{
                int base = map.get(car) - fees[0];//기본요금 빼고
                int dan = base / fees[2];
                if(base % fees[2] != 0){//나눠떨어지면
                    dan += 1;
                }
                
                int price = fees[1] + (dan * fees[3]);
                answer.add(price);
            }
            
        }
        
        
        return answer;
    }
}