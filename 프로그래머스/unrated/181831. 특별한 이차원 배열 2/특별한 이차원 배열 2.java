class Solution {
    public int solution(int[][] arr) {
        boolean flag = true;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i == j ) continue;
                if( arr[i][j] != arr[j][i]){
                    flag = false;
                }
            }
        }
        
        if(flag == true) return 1;
        else return 0;

    }
}