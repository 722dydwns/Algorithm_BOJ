
import java.util.Scanner;

public class Main {	
	//솔루션 함수 (문자열) => 개수 리턴 
	public int solution(String str) {
		int answer = 0;
		for(int i = 0; i< str.length(); i++) {
			answer++;
		}

		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		// 문자열 입력
		String str = kb.next();

		//솔루션 리턴값 출력
		System.out.println(T.solution(str));
	}

}