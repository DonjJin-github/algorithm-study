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

        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visit[i][j] || graph[i][j]==0)
                    continue;
                count = 0;
                ans++;
                dfs(i,j,N);
                list.add(count);
            }
        }
        
        Collections.sort(list);
        bw.write(ans+"\n");
        for(int print : list){
            bw.write(print+"\n");
        }
        bw.flush();
    }
    static void dfs(int x, int y, int N){
        visit[x][y] = true;
        count++;

        for(int i=0;i<4;i++){
            int nx = x +dx[i];
            int ny = y +dy[i];

            if(nx<0 || nx>=N || ny<0 || ny>=N)
                continue;
            
            if(!visit[nx][ny] && graph[nx][ny]==1)
                dfs(nx, ny, N);
        }
    }
}