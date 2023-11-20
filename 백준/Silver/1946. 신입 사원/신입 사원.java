import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 1946번. 신입사원 - 그리디 
 * @author MYLG
 *
 */
class Sawon implements Comparable<Sawon>{
	int s, m;
	Sawon(int s, int m){
		this.s = s;
		this.m = m;
	}
	@Override
	public int compareTo(Sawon o) {
		// TODO Auto-generated method stub
		return this.s - o.s;//서류 오름차순 정렬
	}
}

public class Main {
	static int TC;
	static int N;
	static List<Sawon> arr;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		TC = kb.nextInt();
		List<Integer> answer = new ArrayList<>();
		
		for(int t = 0; t<TC; t++) {
			N = kb.nextInt();
			
			arr = new ArrayList<>();
			
			for(int i=0; i<N; i++) {
				int s = kb.nextInt();
				int m = kb.nextInt();
				arr.add(new Sawon(s, m));
			}
			
			Collections.sort(arr);
			//그리디s
			int cutLine = arr.get(0).m;///서류 1등의 면접 점수가 커트라인이 됨
			int cnt = 1;
			for(int i=1; i<N; i++) {
				//현재 커트라인보다 더 높은 순위의 면접 가진다 == 둘다 떨어지는 애가 아니라 적어도 면접 순위가 높은 애이므로 선발 
				if(cutLine > arr.get(i).m) {
					cnt++;//한명 선발 됐고 
					cutLine = arr.get(i).m;//얘로 커트라인 갱신 
				}
			}
			
			answer.add(cnt);
		}
		
		//답 출력 
		for(int x : answer) {
			System.out.println(x);
		}
		
	}

}
