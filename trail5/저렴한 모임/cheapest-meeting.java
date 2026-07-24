import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] distance = new int[N+1][N+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                distance[i][j] = INF;
                if(i==j)
                    distance[i][j] = 0;
            }
        }
        st = new StringTokenizer(br.readLine());
        int startA = Integer.parseInt(st.nextToken());
        int startB = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            distance[u][v] = Math.min(distance[u][v],cost);
            distance[v][u] = Math.min(distance[u][v],cost);
        }

        for(int i=1;i<=N;i++){
            for(int s=1;s<=N;s++){
                for(int t=1;t<=N;t++){
                    if(distance[s][t]>distance[s][i] + distance[i][t])
                        distance[s][t] = distance[s][i] + distance[i][t];
                }
            }
        }

        int cost = INF;
        for(int i=1;i<=N;i++){
            int d = distance[startA][i] + distance[startB][i] + distance[i][end];
            cost = Math.min(cost, d);
        }

        if(cost == INF)
            bw.write("-1\n");
        else
            bw.write(cost+"\n");
        
        bw.flush();
    }
}