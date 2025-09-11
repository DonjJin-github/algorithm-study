import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] combination = new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            combination[i][0] = 1;
            combination[i][i] = 1;
            for(int j=1;j<i;j++){
                combination[i][j] = (combination[i-1][j-1] + combination[i-1][j]) %10007;
            }
        }

        bw.write(combination[N][M]+"\n");
        bw.flush();

    }
}
