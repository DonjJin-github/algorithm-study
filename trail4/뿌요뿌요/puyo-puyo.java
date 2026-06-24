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

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visit = new boolean[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans[] = {0, -1};
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[i][j])
                    continue;

                count = 0;
                dfs(i, j, N, graph[i][j]);
                if(count >=4)
                    ans[0]++;
                
                ans[1] = Math.max(count, ans[1]);
            }
        }
        bw.write(ans[0]+" "+ ans[1]);
        bw.flush();

    }
    static void dfs(int x, int y, int N, int t){
        visit[x][y] = true;
        count++;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=N)
                continue;
            
            if(!visit[nx][ny] && graph[nx][ny] == t)
                dfs(nx, ny, N, t);
        }

    }
}