import java.util.Scanner;

public class Main {	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		//1) 입력 
		int A = kb.nextInt();
		int B = kb.nextInt();
		int C = kb.nextInt();
		
		//2) 출력 덧붙임
		System.out.println( (A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println( (A*B)%C);
		System.out.println( ((A%C)* (B%C))%C);
	}
}