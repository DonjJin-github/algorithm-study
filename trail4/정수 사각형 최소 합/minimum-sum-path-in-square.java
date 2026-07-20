import java.util.*;
import java.io.*;

public class Main {
    static int arr[][];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        dp = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][N-1] = arr[0][N-1];
        for(int i=N-2;i>=0;i--){
            dp[0][i] = dp[0][i+1] + arr[0][i];
        }
        for(int i=1;i<N;i++){
            dp[i][N-1] = dp[i-1][N-1] + arr[i][N-1];
        }

        for(int i = 1;i<N;i++){
            for(int j=N-2;j>=0;j--){
                dp[i][j] = Math.min(dp[i][j+1]+arr[i][j], dp[i-1][j]+arr[i][j]);
            }
        }
        
        bw.write(dp[N-1][0]+"\n");
        bw.flush();
    }
}