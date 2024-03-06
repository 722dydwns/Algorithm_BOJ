import java.util.*;
class Solution {
    private int[] answer;
    private int[] parent;
    //재귀
    private void DFS(int idx, int price){
        int referral = price / 10;
        answer[idx] += price - referral;

        if (parent[idx] != -1 && referral > 0) {
            DFS(parent[idx], referral);
        }
    }
    //솔루션 함수
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int N = enroll.length;
        answer = new int[N];

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++){
            map.put(enroll[i], i);
        }

        //부모 세팅
        parent = new int[N];
        for(int i=0; i<N; i++){
            if(map.containsKey(referral[i])){
                parent[i] = map.get(referral[i]);
            } else {
                parent[i] = -1;
            }
        }

        for(int i=0; i<seller.length; i++){
            int cur_price = amount[i] * 100;
            int cur_idx = map.get(seller[i]);

            DFS(cur_idx, cur_price);
        }

        return answer;
    }
}