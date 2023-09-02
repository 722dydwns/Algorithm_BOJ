import java.util.Scanner;

public class Main {
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		//1) 입력
		String str = kb.nextLine().trim(); //앞뒤 공백 제거
		String t[] = str.split(" ");
		
		if(t.length == 1 && t[0].equals("")) {
			System.out.println(0);
		}else {
			System.out.println(t.length);
		}
		
		System.out.println();
	}
}