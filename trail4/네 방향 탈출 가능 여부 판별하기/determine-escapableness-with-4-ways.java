import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int N;
    static int M;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        
        if(visit[N-1][M-1])
            bw.write("1\n");
        else
            bw.write("0\n");

        bw.flush();
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                if(visit[nx][ny] || arr[nx][ny] == 0)
                    continue;
            
                visit[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }
}