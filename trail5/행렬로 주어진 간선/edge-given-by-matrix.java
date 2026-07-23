import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] distance = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                distance[i][j] = Integer.parseInt(st.nextToken());
                if(i==j)
                    distance[i][j] = 1;
                else if(distance[i][j] == 0)
                    distance[i][j] = INF;
            }
        }

        for(int i=0;i<N;i++){
            for(int s=0;s<N;s++){
                for(int t=0;t<N;t++){
                    if(distance[s][t]>distance[s][i]+distance[i][t])
                        distance[s][t] = distance[s][i]+distance[i][t];
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(distance[i][j] == INF)
                    bw.write("0 ");
                else
                    bw.write("1 ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}