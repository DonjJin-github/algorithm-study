import java.util.*;
import java.io.*;

public class Main {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;

        for(int i=3;i<=N;i++){
            dp[i] = ((dp[i-1]) + (dp[i-2]*2)) % 10007;
        }

        bw.write(dp[N]+"\n");
        bw.flush();
    }
}