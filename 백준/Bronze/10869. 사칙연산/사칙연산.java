import java.util.Scanner;
public class Main {	

	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		Scanner kb = new Scanner(System.in);
		//1) 입력 : 첫 줄에 A, B 받음
		int a = kb.nextInt();
		int b = kb.nextInt();

		//2) 출력
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
	}
}