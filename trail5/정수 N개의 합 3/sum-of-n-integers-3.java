import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] sum = new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            sum[i][0] = 0;
            sum[0][i] = 0;
        }
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int x = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + x;
            }
        }

        int ans = 0;
        for(int i=K;i<=N;i++){
            for(int j=K;j<=N;j++){
                int cost = sum[i][j] - (sum[i-K][j] + sum[i][j-K] - sum[i-K][j-K]);
                ans = Math.max(cost,ans);
            }
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}