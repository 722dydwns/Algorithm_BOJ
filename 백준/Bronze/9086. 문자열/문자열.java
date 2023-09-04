import java.util.Scanner;

public class Main {	
	//솔루션 함수 (문자열) => 개수 리턴 
	public String solution(String  str) {
		String answer = "";
		
		for(int i = 0; i<str.length(); i++) {
			char[] tmp = str.toCharArray();
			
			/// 문자 1개의 문자열인 경우 
			if(tmp.length == 1) {
				answer += tmp[i];
			}
			
			if(i==0) { //첫글자
				answer += tmp[i];
			}else if(i == tmp.length -1) { //끝글자
				answer += tmp[i];
			}
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		
		//1) 첫줄 입력 : 개수 T 입력 
		int n = kb.nextInt();
		
		//2) T개 만큼 String []에 입력 
		String[] str = new String[n]; //n개 배열 문자열로 받고 
			// n번 만큼 문자열 입력받기 
		for(int i = 0; i<n; i++	) {
			str[i] = kb.next();
		}

		//솔루션 리턴값 출력
		for(int i = 0; i<n; i++) {
			System.out.println(T.solution(str[i]));
		}
	}
}