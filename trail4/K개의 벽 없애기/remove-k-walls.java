import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        int[][][] distance = new int[N][N][K+1];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++)
                Arrays.fill(distance[i][j], -1);
        }

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int start[] = new int[2];
        int end[] = new int[2];
        st = new StringTokenizer(br.readLine());
        start[0] = Integer.parseInt(st.nextToken())-1;
        start[1] = Integer.parseInt(st.nextToken())-1;
        st = new StringTokenizer(br.readLine());
        end[0] = Integer.parseInt(st.nextToken())-1;
        end[1] = Integer.parseInt(st.nextToken())-1;
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1], 0});
        distance[start[0]][start[1]][0] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N)
                    continue;
                if(arr[nx][ny] == 1){
                    if(cur[2]<K){
                        if(distance[nx][ny][cur[2]+1] != -1)
                            continue;
                        distance[nx][ny][cur[2]+1] = distance[cur[0]][cur[1]][cur[2]]+1;
                        q.add(new int[]{nx, ny, cur[2]+1});
                    }
                }else{
                    if(distance[nx][ny][cur[2]] != -1)
                        continue;
                    distance[nx][ny][cur[2]] = distance[cur[0]][cur[1]][cur[2]]+1;
                    q.add(new int[]{nx, ny, cur[2]});
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<=K;i++){
            if(distance[end[0]][end[1]][i] == -1)
                continue;
            ans = Math.min(ans, distance[end[0]][end[1]][i]);
        }
        if(ans == Integer.MAX_VALUE)
            bw.write("-1\n");
        else
            bw.write(ans+"\n");
        bw.flush();
    }
}