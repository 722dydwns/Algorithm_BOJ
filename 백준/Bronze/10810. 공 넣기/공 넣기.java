/* 백준.10810번. 공 넣기
 * 최대한 문제 이해하려고 노력했다. 
 * 
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 공백 구분해서 
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//1) N, M 입력 받기 
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		//2) N개의 바구니 만들기 
		int[] num = new int[N];

		//3) M번의 공 넣는 방식 적용 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			// (j, k, l) 방식으로 
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			for (int num2 = (j - 1); num2 < k; num2++) {
				num[num2] = l;
			}
		}

		for (int i = 0; i < num.length; i++) {
			if ((i - 1) == num.length) {
				System.out.print(num[i]);
			}
			System.out.print(num[i] + " ");

		}

	}
}