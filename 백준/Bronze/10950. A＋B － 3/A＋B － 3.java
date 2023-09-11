import java.util.Scanner;
/* 백준. A + B - 3
 * [설명]두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt();
		int[] ans = new int[t];
		
		for(int i = 0; i < t; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			ans[i] = a+b;
		}
		
		for(int i = 0; i<t; i++) {
			System.out.println(ans[i]);
		}
	}
}