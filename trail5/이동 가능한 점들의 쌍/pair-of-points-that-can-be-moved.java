import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] distance = new int[N+1][N+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                distance[i][j] = INF;
                if(i==j)
                    distance[i][j] = 0;
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            distance[u][v] = Math.min(distance[u][v], cost);
        }

        for(int i=1;i<=N;i++){
            for(int s=1;s<=N;s++){
                for(int t=1;t<=N;t++){
                    if(distance[s][t]>distance[s][i]+distance[i][t]){
                        distance[s][t] = distance[s][i]+distance[i][t];
                    }
                }
            }
        }
        int ans = 0;
        ArrayList<Integer> ansCost = new ArrayList<>();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int cost = INF;
            for(int j=1;j<=P;j++){
                int d = distance[start][j] + distance[j][end];
                cost = Math.min(cost, d);
            }

            if(cost!=INF){
                ans++;
                ansCost.add(cost);
            }
        }

        long sum = 0;
        bw.write(ans+"\n");
        for(int temp : ansCost){
            sum+=temp;
        }
        bw.write(sum+"\n");
        bw.flush();
    }
}