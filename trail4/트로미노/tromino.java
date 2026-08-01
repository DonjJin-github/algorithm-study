import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M-2;j++){
                int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                ans = Math.max(ans, temp);
            }
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N-2;j++){
                int temp = arr[j][i] + arr[j+1][i] + arr[j+2][i];
                ans = Math.max(ans, temp);
            }
        }

        for(int i=0;i<N-1;i++){
            for(int j=0;j<M-1;j++){
                int sum1 = arr[i][j] + arr[i][j+1] +arr[i+1][j];
                int sum2 = arr[i][j] + arr[i][j+1] +arr[i+1][j+1];
                int sum3 = arr[i][j] + arr[i+1][j] +arr[i+1][j+1];
                int sum4 = arr[i][j+1] + arr[i+1][j] +arr[i+1][j+1];
                ans = Math.max(Math.max(ans, sum1), Math.max(sum2, Math.max(sum3, sum4)));
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
