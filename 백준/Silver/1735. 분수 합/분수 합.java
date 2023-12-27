import java.util.Scanner;

/**
 * 1735번. 분수 합 - gcd 활용 
 */
public class Main {
	static int gcd(int a, int b) {
		int r = a % b;
		if(r==0) return b;
		else return gcd(b, r);
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int a = kb.nextInt();//분자
		int A = kb.nextInt();//분모
		
		int b = kb.nextInt();
		int B = kb.nextInt();
		
		int M = A * B;
		int m = (a*B) + (b * A);
		
		int gcd = gcd(M, m);
		M /= gcd;
		m /= gcd;
		
		System.out.println(m + " " + M);
	}
}