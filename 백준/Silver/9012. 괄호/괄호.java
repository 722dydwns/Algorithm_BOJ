import java.util.*;

/* 9012번 괄호 
 * */
public class Main {
	//솔루션 함수
	public String solution(int n, String arr ) {

		Stack<Character> st = new Stack<>();
		
		for(Character x : arr.toCharArray()) {
			if(x=='(') st.push(x);
			else {
				if(st.size() > 0 ) st.pop();
				else {
					return "NO";
				}
			}
		}
		
		if(st.isEmpty()) {
			return "YES";
		}
		
		return "NO";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = Integer.parseInt( kb.nextLine()); 
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextLine();
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(T.solution(n, arr[i]));
		}
		
	}
}