import java.util.Scanner;

// 10159번. 저울 - 플로이드 문풀 
public class Main {
	
	static int N, M;
	static boolean[][] chk;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		
		chk = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			chk[a][b] = true;
		}
		
		//플로이드
		for(int k=1; k<=N; k++) { //k를 거쳐서 
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(chk[i][k] && chk[k][j]) {
						chk[i][j] = true;//이렇게도 연결처리  
					}
				}
			}
		}
		
		//역순으로도 들어오는 건 다 연결점이라고 생각해야 함 
		int[] cnt = new int[N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(chk[i][j] || chk[j][i]) {
					cnt[i]++;
				}
			}
			
		}
		for(int i=1; i<=N; i++) {
			System.out.println(N-1-cnt[i]);
		}
		
	}

}
