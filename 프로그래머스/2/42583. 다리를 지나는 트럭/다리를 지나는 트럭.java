import java.util.*;

class Solution {
        private int getWeight(int[] bridge){
            int sum = 0;
            for(int x : bridge) sum += x;
            return sum;
        }

        private void move(int[] bridge) {
            for (int i = bridge.length - 1; i >= 0; i--) {
                if (i == 0) {
                    bridge[i] = 0;
                    break;
                }

                bridge[i] = bridge[i - 1];
            }
        }

        //솔루션 함수
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int time = 0;

            int[] bridge = new int[bridge_length];
            int truck_idx = 0;
            while(true){
                time++;

                // 현재 다리에 있는 모든 트럭을 한칸씩 옮김
                move(bridge);

                // 현재 다리에 새 트럭 들어올 수 있으면 들어감
                if (truck_idx < truck_weights.length) { // 대기중인 트럭이 있는 경우
                    if(getWeight(bridge) + truck_weights[truck_idx] <= weight){
                        bridge[0] = truck_weights[truck_idx];
                        truck_idx++;
                    }
                }

                if (truck_idx >= truck_weights.length && getWeight(bridge) == 0) {
                    break;
                }
            }

            return time;
        }
    }