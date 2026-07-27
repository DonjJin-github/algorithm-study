import java.util.*;
import java.io.*;

public class Main {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] distance;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        distance = new int[N][M];
        for(int i=0;i<N;i++)
            Arrays.fill(distance[i], -1);
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        distance[0][0] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0;i<4;i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M)
                    continue;
                if(distance[nx][ny] != -1 || arr[nx][ny] == 0)
                    continue;
                
                q.add(new int[]{nx,ny});
                distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
            }
        }

        bw.write(distance[N-1][M-1]+"\n");
        bw.flush();
    }
}