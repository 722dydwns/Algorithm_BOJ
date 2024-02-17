import java.util.*;
import java.io.*;


public class Main {

    static int N, M, R;
    static int[][] map;
    // 시계 반대방향
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
            	map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 1. 5*2 + 4*2-4 = 14칸(겉테두리)
        // 2. 3*2 + 2*2-4 = 6칸 (속테두리)
        int n = N;
        int m = M;
        for(int i = 0; i < Math.min(N, M) / 2; i++) {
            rotate(i, (n*2) + (m*2 - 4));
            // 박스 안으로 들어갈 때마다 가로 세로 2칸씩 줄어든다.
            n -= 2;
            m -= 2;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
            	sb.append(map[i][j] + " ");
            }
            sb.append("\n");
            }
        System.out.println(sb);
    }

    static void rotate(int start, int len) {
        // 1. 7 % 14 = 7칸이동
        // 2. 7 % 6 = 1칸이동
        int move = R % len;

        for(int i = 0; i < move; i++) {
            int now = map[start][start];

            int y = start;
            int x = start;
            int idx = 0;

            while(idx < 4) {
                int ny = y + dy[idx];
                int nx = x + dx[idx];
                if(ny >= start && ny < N-start && nx >= start && nx < M-start) {
                    map[y][x] = map[ny][nx];
                    y = ny;
                    x = nx;
                } else {
                    // 배열 범위를 넘어가면 다 옮긴 것이므로 인덱스 증가
                    idx++;
            	}
        	}
            // now에 next를 넣는 방식 (마지막)
            map[start+1][start] = now;
        }
    }

}
         