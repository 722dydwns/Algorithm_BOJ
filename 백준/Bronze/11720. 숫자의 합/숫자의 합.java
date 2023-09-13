import java.util.Scanner;

public class Main {	
	//솔루션 함수 
	public int solution(int n, String  str) {
		int answer = 0;
		
		for(int i = 0; i<n; i++) {
			answer += str.charAt(i)-48; // 또는 - '0'  
			//2. 문자열에 있는 각 숫자를 한 자리씩 읽고 싶을 때, charAt() 함수를 사용하면 된다.
				//charAt()만 쓰면 아스키 코드 값이 나오는듯?
				// charAt()-'0'까지 적어야 원하는 '숫자 값'을 얻을 수 있다.
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		//1) N 입력
		int n = kb.nextInt();
		//2) 문자열로 입력받기 
		String str = kb.next();
			
		// 정답 출력 
		System.out.println(T.solution(n, str));
	}
}