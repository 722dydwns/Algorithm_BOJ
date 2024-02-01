import java.util.*;

class Solution {
    static int diceCount;
    static boolean[] visited;
    static List<int[]> A = new ArrayList<>();
    static List<int[]> B = new ArrayList<>();
    
    static int[] result;
    static List<Integer> A_result;
    static List<Integer> B_result;
    
    // 재귀로 주사위 combination
    static void combination(int idx, int count){
        if(count == diceCount/2){
            int[] Atmp = new int[diceCount/2];
            int[] Btmp = new int[diceCount/2];
            
            int A_idx =0;
            int B_idx =0;
            for(int i=0; i<diceCount; i++){
                if(visited[i]){
                    Atmp[A_idx] = i+1;
                    A_idx++;
                }
                if(!visited[i]){
                    Btmp[B_idx] = i+1;
                    B_idx++;
                }
            }
            //각각의 조합 구성을 각 리스트에 담는다. 
            A.add(Atmp); 
            B.add(Btmp);
            return;
        }
        
        //전체 주사위 순회하면서
        for(int i=idx; i<diceCount; i++){
            visited[i] = true;
            combination(i+1, count+1);
            visited[i] = false;
        }
    }
    
    //calculate -> 각 눈의 합 종류 담음
    static void calculate(int idx, int[] dices, int[][] originDices, int sum, List<Integer> team){
        if(idx == dices.length){
            team.add(sum);
            return;
        }
        for(int i=0; i<6; i++){
            calculate(idx+1, dices, originDices, sum + originDices[dices[idx]-1][i], team);
        }
    }
    
    //솔루션 함수 
    public int[] solution(int[][] dice) {
        diceCount = dice.length;
        visited = new boolean[diceCount];
        
        //A,B에게 주사위 절반씩 나눌 수 있는 구성 전체 경우의 수 구함
        combination(0, 0);        
        
        int max = Integer.MIN_VALUE;
        int index = 0;
        
        for(int i=0; i<A.size(); i++){
            A_result = new ArrayList<>();
            B_result = new ArrayList<>();
            //A,B 각각 조합에 대한 주사위 눈 합
            calculate(0, A.get(i), dice, 0, A_result);
            calculate(0, B.get(i), dice, 0, B_result);
            //A,B 각각 조합에 대한 눈의 합 구한 리스트 오름차순 정렬 
            Collections.sort(A_result);
            Collections.sort(B_result);
            
            //A가 이길 경우를 구해야 함 
            int totalWinCount=0; 
            for(int a : A_result) { 
                //A 주사위의 조합으로 나올 수 있는 모든 합 각각을 돌면서
                int left = 0;
                int right = B_result.size();
                
                while(left+1 < right){
                    int mid = (left+right)/2; 
                    //A의 현재 합이 B의 중앙위치의 합보다 큰지 작은지에 따른 이분탐색 
                    if(a > B_result.get(mid)){
                        left=mid; //크다면 뒤쪽 범위에서 다시 탐색
                    }else right = mid;//작다면 앞쪽 범위에서 탐색 
                }
                //이기는 경우의 합을 다 더함
                totalWinCount += left;
            }
            //가장 큰 승률로 갱신
            if(max < totalWinCount){
                max = totalWinCount;
                index = i;
            }
        }
        result = A.get(index);
        
        return result;
    }
}