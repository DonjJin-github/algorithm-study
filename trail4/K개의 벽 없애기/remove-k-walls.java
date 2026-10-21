import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][][] distance;
    static int[] start = new int[2];
    static int[] end = new int[2];
    static int N;
    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        distance = new int[N][N][K+1];

        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;

        bfs();
        
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=K;i++){
            if(distance[end[0]][end[1]][i] != 0)
                ans = Math.min(distance[end[0]][end[1]][i],ans);
        }
        if(ans == Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(ans-1+" ");
        bw.flush();
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], 0});
        distance[start[0]][start[1]][0] = 1;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;

                if(arr[nx][ny] == 1){
                    if(cur[2]>=K)
                        continue;
                    if(distance[nx][ny][cur[2]+1] != 0)
                        continue;
                    
                    q.add(new int[]{nx, ny, cur[2]+1});
                    distance[nx][ny][cur[2]+1] = distance[cur[0]][cur[1]][cur[2]]+1;
                }
                else{
                    if(distance[nx][ny][cur[2]] != 0)
                        continue;
                                    
                    q.add(new int[]{nx, ny, cur[2]});
                    distance[nx][ny][cur[2]] = distance[cur[0]][cur[1]][cur[2]]+1;
                }
            }
        }
    }
}