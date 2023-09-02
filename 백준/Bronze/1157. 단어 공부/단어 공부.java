import java.util.Scanner;

public class Main {
	//솔루션 함수 
	public String solution(String str) {
		String answer = "";
		
		//방식 : A ~ Z 까지 담을 배열에 넣고 
		// 받은 문자열 내부에 해당하는 문자에 카운팅한다.
		int[] cnt = new int[26]; //카운팅용 배열 
		
		for(int i =0; i<str.length(); i++) {
			//뽑으 각 문자의 인덱스 가져오기 위해 
			int tmp = str.charAt(i) - 65; 
			//해당 문자 인덱스의 배열 상에 카운팅 ++ 한다 발견할때마다.
			cnt[tmp]++;
		}
		
		int max = 0;
		for(int i = 0; i<cnt.length; i++) {
			if(cnt[i]>max) {
				max = cnt[i];
				char tmp = (char) (i+65);//문자로 뽑기
				answer = String.valueOf(tmp); //답에 넣기 
			}else if(cnt[i] == max) { //max 동일하면 그냥 ? 출력
				answer = "?"; 
			}
		}
		return answer;
	}
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		//1) 입력
		String str = kb.next().toUpperCase();//대소문자 구분 X
		
		//2) 출력 
		System.out.println(T.solution(str));
	}
}