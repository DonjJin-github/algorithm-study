import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int H;
    static int M;
    static int[][] arr;
    static int[][] ans;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ans = new int[N][N];
        int[][] human = new int[H][2];

        int idx = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    human[idx][0] = i;
                    human[idx][1] = j;
                    idx++;
                }
            }
        }

        for(int i=0;i<H;i++){
            bfs(new int[]{human[i][0], human[i][1]});
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(ans[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
    static void bfs(int[] start){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[][] visit = new boolean[N][N];
        int[][] distance = new int[N][N];
        
        q.add(new int[]{start[0], start[1]});
        visit[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            boolean flag = false;
            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(visit[nx][ny] || arr[nx][ny] == 1)
                    continue;

                if(arr[nx][ny] == 3){
                    ans[start[0]][start[1]] = distance[cur[0]][cur[1]] + 1;
                    flag = true;
                    break;
                }
                visit[nx][ny] = true;
                distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                q.add(new int[]{nx, ny});
            }
            if(flag)
                break;
        }
        if(ans[start[0]][start[1]] == 0)
            ans[start[0]][start[1]] = -1;
    }
}