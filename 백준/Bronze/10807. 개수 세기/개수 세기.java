import java.util.Scanner;

public class Main {
	//솔루션 함수 
	public int solution(int n, int arr[], int v) {
		int answer = 0;
		
		for(int i =0; i< n; i++) {
			if(arr[i] == v) answer += 1; 
		}
		return answer;
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		//1) 입력
		int n = kb.nextInt();
		int[] arr = new int[n];
		
		for(int i =0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		int v = kb.nextInt();
		
		//2) 출력 
		System.out.println(T.solution(n, arr, v));
	}
}