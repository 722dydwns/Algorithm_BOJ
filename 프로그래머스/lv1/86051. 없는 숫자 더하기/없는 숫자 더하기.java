class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int[] arr = new int[10];
        
        for(int x : numbers){
            arr[x]++;//개수 누적시키기 
        }
        
        for(int i=0; i<=9; i++){
            if(arr[i] == 0){ //누적했는데도 0을 갖는 i에 대하여
                answer += i;
            }
        }
        
        
        return answer;
    }
}