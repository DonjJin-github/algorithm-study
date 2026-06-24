import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                graph[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,N,M);

        if(visit[N-1][M-1])
            bw.write("1");
        else
            bw.write("0");
        
        bw.flush();
    }
    static void dfs(int x, int y, int N, int M){
        visit[x][y] = true;

        for(int i=0;i<2;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=M){
                continue;
            }

            if(!visit[nx][ny] && graph[nx][ny] == 1)
                dfs(nx, ny, N, M);
        }
    }
}