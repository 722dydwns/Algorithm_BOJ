import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());

    long[] tile = new long[1000001];

    tile[1] = 1; tile[2] = 2; tile[3] = 3;
    if(n > 3) {
      for(int i = 3; i <= n; i++) {
        tile[i] = tile[i-1] + tile[i-2];
        tile[i] %= 15746;
      }
    }
    bw.write(String.valueOf(tile[n]));

    bw.flush();
    bw.close();
  }
}