import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 100000000;
    static int[][] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        distance = new int[N+1][N+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                distance[i][j] = INF;
                if(i==j)
                    distance[i][j] = 0;
            }
        }

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                distance[i][j] = Math.min(distance[i][j], Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=1;i<=N;i++){
            for(int s=1;s<=N;s++){
                for(int t=1;t<=N;t++){
                    if(distance[s][t] > distance[s][i]+distance[i][t]){
                        distance[s][t] = distance[s][i]+distance[i][t];
                    }
                }
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(distance[start][end]+"\n");
        }
        bw.flush();
    }
}