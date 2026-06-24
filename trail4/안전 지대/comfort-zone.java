import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visit;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        int K = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                K = Math.max(graph[i][j],K);
            }
        }

        int[] ans = {-1,-1};

        for(int k=1;k<=K;k++){
            visit = new boolean[N][M];
            count = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(visit[i][j] || graph[i][j] - k <= 0)
                        continue;
                    dfs(i,j,k,N,M);
                    count++;
                }
            }
            if(ans[1]<count){
                ans[1] = count;
                ans[0] = k; 
            }
        }
        bw.write(ans[0]+" "+ ans[1]);
        bw.flush();
    }
    static void dfs(int x, int y, int K, int N, int M){
        visit[x][y] = true;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M)
                continue;
            
            if(!visit[nx][ny] && graph[nx][ny] - K >0)
                dfs(nx, ny, K, N, M);
        }
    }
}