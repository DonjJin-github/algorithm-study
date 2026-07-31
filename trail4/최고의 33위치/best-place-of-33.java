import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i=0;i<=N-3;i++){
            for(int j=0;j<=N-3;j++){
                int count = 0;
                for(int x=i;x<i+3;x++){
                    for(int y=j;y<j+3;y++){
                        if(arr[x][y] == 1)
                            count++;
                    }
                }
                ans = Math.max(ans, count);
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}