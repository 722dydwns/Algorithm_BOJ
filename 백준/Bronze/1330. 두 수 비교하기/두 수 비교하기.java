import java.util.Scanner;

public class Main {
	//솔루션 함수 
	public String solution(int a, int b) {
		String answer = "";
		
		if(a > b) {
			answer = ">";
		}else if(a < b) {
			answer = "<";
		}else if(a == b) {
			answer = "==";
		}
		
		return answer;
	}
	
	//메인 함수 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		int a = kb.nextInt();
		int b = kb.nextInt();
		
		System.out.println(T.solution(a, b));	
	}
}