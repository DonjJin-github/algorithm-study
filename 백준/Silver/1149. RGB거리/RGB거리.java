import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][3];
        int sum[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sum[0][0] = arr[0][0];
        sum[0][1] = arr[0][1];
        sum[0][2] = arr[0][2];

        sum[1][0] = arr[1][0] + Math.min(arr[0][1], arr[0][2]);
        sum[1][1] = arr[1][1] + Math.min(arr[0][0], arr[0][2]);
        sum[1][2] = arr[1][2] + Math.min(arr[0][0], arr[0][1]);

        for (int i = 2; i < n; i++) {
            sum[i][0] = arr[i][0] + Math.min(sum[i - 1][1], sum[i - 1][2]);
            sum[i][1] = arr[i][1] + Math.min(sum[i - 1][0], sum[i - 1][2]);
            sum[i][2] = arr[i][2] + Math.min(sum[i - 1][0], sum[i - 1][1]);
        }

        int ans = Math.min(sum[n - 1][0], sum[n - 1][1]);

        bw.write(Math.min(ans, sum[n - 1][2]) + "\n");
        bw.flush();
    }
}
