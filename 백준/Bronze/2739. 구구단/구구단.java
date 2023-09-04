import java.util.Scanner;

/* 백준 2739번. 구구단 
 * [설명]
 * N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		
		for(int i = 1; i<10; i++) {
			System.out.println(N+ " * " + i + " = " + N*i);
		}
		
	}
}