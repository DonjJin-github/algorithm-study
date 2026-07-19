import java.util.*;
import java.io.*;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[1001];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for(int i=4;i<=N;i++){
            dp[i] = (dp[i-3] + dp[i-2]) % 10007;
        }

        bw.write(dp[N]+"\n");
        bw.flush();
        
    }
}