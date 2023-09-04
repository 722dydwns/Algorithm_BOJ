import java.util.Scanner;

public class Main {	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		//1) 입력 
		int A = kb.nextInt();
		int B = kb.nextInt();
		
		//2) 출력 
		System.out.println( (B%10 ) * A);
		System.out.println( ((B % 100)/10) * A);
		System.out.println( (B/100) * A);
		System.out.println( A * B);
	}
}